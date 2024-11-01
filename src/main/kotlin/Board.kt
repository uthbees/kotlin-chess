import kotlin.math.abs

class Board(val state: List<List<Piece?>> = defaultBoardState.toMutableList()) {
    // The ghost pawn keeps track of pawns who moved two spaces last turn for en passant
    // purposes. It should not be copied over to the new board when a move is made, since
    // it should only be around for one turn.
    var ghostPawn: GhostPawn? = null

    data class GhostPawn(val ghostLocation: Location, val realLocation: Location)

    /**
     * A utility function to get the piece at a given location.
     * */
    fun at(location: Location): Piece? {
        return state[location.rowIndex][location.columnIndex]
    }

    fun inCheck(playerColor: PlayerColor): Boolean {
        var kingLocation: Location? = null

        for ((rowIndex, row) in state.withIndex()) {
            for ((columnIndex, cell) in row.withIndex()) {
                if (cell?.type == PieceType.KING && cell.color == playerColor) {
                    assert(kingLocation == null)
                    kingLocation = Location(rowIndex, columnIndex)
                }
            }
        }

        assert(kingLocation != null)

        return cellIsThreatened(kingLocation!!, playerColor)
    }

    /**
     * Is a cell threatened?
     * Caution - is subject to the same limitations as getRawValidPieceMoves and thus should only be
     * used for determining where kings are allowed to move (since king threats are symmetrical).
     * */
    private fun cellIsThreatened(targetCell: Location, playerColor: PlayerColor): Boolean {
        for ((rowIndex, row) in state.withIndex()) {
            for ((columnIndex, cell) in row.withIndex()) {
                if (cell != null && cell.color != playerColor) {
                    val pieceValidMoves = getRawValidPieceMoves(Location(rowIndex, columnIndex))

                    if (pieceValidMoves.contains(targetCell)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    /**
     * Returns a list of all the valid moves of the piece at a given location on this board.
     * Takes all factors including check into account.
     * */
    fun getValidPieceMoves(pieceLocation: Location, playerColor: PlayerColor): List<Location> {
        assert(this.at(pieceLocation)?.color == playerColor)

        val validPieceMoves = getRawValidPieceMoves(pieceLocation).toMutableList()
        validPieceMoves.addAll(getValidCastlingPieceMoves(pieceLocation, playerColor))

        // Filter out all moves that would leave us in check afterward.
        return validPieceMoves.filter { rawValidPieceMove ->
            val virtualBoardState = state.map {
                it.toMutableList()
            }
            virtualBoardState[rawValidPieceMove.rowIndex][rawValidPieceMove.columnIndex] =
                virtualBoardState[pieceLocation.rowIndex][pieceLocation.columnIndex]?.copy()
            virtualBoardState[rawValidPieceMove.rowIndex][rawValidPieceMove.columnIndex]!!.hasMoved = true
            virtualBoardState[pieceLocation.rowIndex][pieceLocation.columnIndex] = null
            val virtualBoard = Board(virtualBoardState)

            !virtualBoard.inCheck(playerColor)
        }
    }

    /**
     * Returns a list of all the valid moves of the piece at a given location on this board.
     * Caution: Does not take check (or player turn) into account and does not include castling. Should
     * only be used as an authoritative list when dealing with where kings are allowed to move (since
     * king threats are symmetrical).
     * */
    private fun getRawValidPieceMoves(pieceLocation: Location): List<Location> {
        val piece = this.at(pieceLocation) ?: return emptyList()

        val validPieceMoves = mutableListOf<Location>()

        /**
         * Add a place to the set of valid moves for the piece if it's a valid cell and
         * there's not another friendly piece there.
         * */
        fun registerReachablePlace(
            rowIndex: Int, columnIndex: Int, canMove: Boolean = true, canCapture: Boolean = true
        ): RegistrationResult {
            val cell = attemptToCreateLocation(rowIndex, columnIndex) ?: return RegistrationResult.INVALID

            if (piece.color != this.at(cell)?.color) {
                if (this.at(cell) == null) {
                    if (canMove) {
                        validPieceMoves.add(cell)
                        return RegistrationResult.UNOCCUPIED_AND_VALID
                    } else {
                        return RegistrationResult.INVALID
                    }
                } else if (canCapture) {
                    validPieceMoves.add(cell)
                    return RegistrationResult.OCCUPIED_BUT_VALID
                } else {
                    return RegistrationResult.INVALID
                }
            }
            return RegistrationResult.INVALID
        }

        /**
         * Add cells in a line to the set of valid moves until we find one that isn't valid.
         * */
        fun registerBlockableLine(pieceLocation: Location, direction: Direction) {
            var blocked = false

            var currentCell: Location? = getNextCellInDirection(pieceLocation, direction)

            while (!blocked && currentCell != null) {
                if (piece.color != this.at(currentCell)?.color) {
                    validPieceMoves.add(currentCell)
                }

                if (this.at(currentCell) != null) {
                    blocked = true
                } else {
                    currentCell = getNextCellInDirection(currentCell, direction)
                }
            }
        }

        when (piece.type) {
            PieceType.KING -> {
                for (rowIndex in pieceLocation.rowIndex - 1..pieceLocation.rowIndex + 1) {
                    for (columnIndex in pieceLocation.columnIndex - 1..pieceLocation.columnIndex + 1) {
                        registerReachablePlace(rowIndex, columnIndex)
                    }
                }

                // The king can also castle, but we have to handle those moves elsewhere in the flow since this
                // function is used in functions that we need to use to handle the castling moves.
            }

            PieceType.QUEEN -> {
                for (direction in Direction.entries) {
                    registerBlockableLine(pieceLocation, direction)
                }
            }

            PieceType.ROOK -> {
                registerBlockableLine(pieceLocation, Direction.NORTH)
                registerBlockableLine(pieceLocation, Direction.EAST)
                registerBlockableLine(pieceLocation, Direction.SOUTH)
                registerBlockableLine(pieceLocation, Direction.WEST)
            }

            PieceType.BISHOP -> {
                registerBlockableLine(pieceLocation, Direction.NORTHEAST)
                registerBlockableLine(pieceLocation, Direction.NORTHWEST)
                registerBlockableLine(pieceLocation, Direction.SOUTHEAST)
                registerBlockableLine(pieceLocation, Direction.SOUTHWEST)
            }

            PieceType.KNIGHT -> {
                registerReachablePlace(pieceLocation.rowIndex - 2, pieceLocation.columnIndex - 1)
                registerReachablePlace(pieceLocation.rowIndex - 2, pieceLocation.columnIndex + 1)
                registerReachablePlace(pieceLocation.rowIndex - 1, pieceLocation.columnIndex - 2)
                registerReachablePlace(pieceLocation.rowIndex + 1, pieceLocation.columnIndex - 2)
                registerReachablePlace(pieceLocation.rowIndex - 1, pieceLocation.columnIndex + 2)
                registerReachablePlace(pieceLocation.rowIndex + 1, pieceLocation.columnIndex + 2)
                registerReachablePlace(pieceLocation.rowIndex + 2, pieceLocation.columnIndex - 1)
                registerReachablePlace(pieceLocation.rowIndex + 2, pieceLocation.columnIndex + 1)
            }

            PieceType.PAWN -> {
                val direction = if (piece.color == PlayerColor.WHITE) {
                    -1
                } else {
                    1
                }

                val result = registerReachablePlace(
                    pieceLocation.rowIndex + 1 * direction, pieceLocation.columnIndex, canCapture = false
                )
                if (!piece.hasMoved && result == RegistrationResult.UNOCCUPIED_AND_VALID) {
                    registerReachablePlace(
                        pieceLocation.rowIndex + 2 * direction, pieceLocation.columnIndex, canCapture = false
                    )
                }
                registerReachablePlace(
                    pieceLocation.rowIndex + 1 * direction, pieceLocation.columnIndex - 1, canMove = false
                )
                registerReachablePlace(
                    pieceLocation.rowIndex + 1 * direction, pieceLocation.columnIndex + 1, canMove = false
                )
                if (ghostPawn != null) {
                    val ghostPawnInReachableColumn =
                        abs(pieceLocation.columnIndex - ghostPawn!!.ghostLocation.columnIndex) == 1
                    val ghostPawnInReachableRow =
                        ghostPawn!!.ghostLocation.rowIndex == pieceLocation.rowIndex + 1 * direction
                    if (ghostPawnInReachableColumn && ghostPawnInReachableRow) {
                        registerReachablePlace(
                            ghostPawn!!.ghostLocation.rowIndex, ghostPawn!!.ghostLocation.columnIndex, canMove = true
                        )
                    }
                }
            }
        }

        return validPieceMoves
    }

    private fun getValidCastlingPieceMoves(pieceLocation: Location, playerColor: PlayerColor): List<Location> {
        val piece = this.at(pieceLocation) ?: return emptyList()
        if (piece.type != PieceType.KING || piece.hasMoved || this.inCheck(playerColor)) {
            return emptyList()
        }

        val validCastlingPieceMoves = mutableListOf<Location>()

        for (rookColumnIndex in listOf(0, 7)) {
            val potentialRook = this.at(Location(pieceLocation.rowIndex, rookColumnIndex))
            if (potentialRook?.type == PieceType.ROOK && !potentialRook.hasMoved) {
                var blocked = false

                // Check if any of the cells the king would pass through are blocked or under attack.
                assert(pieceLocation.columnIndex == 4)
                val range = if (rookColumnIndex == 0) {
                    // Here we also have to make sure that the second column (index 1) is empty so that
                    // the rook can pass through it. (It's okay if it's under attack.)
                    if (this.at(Location(pieceLocation.rowIndex, 1)) != null) {
                        blocked = true
                    }
                    2..3
                } else {
                    5..6
                }
                for (columnIndex in range) {
                    val cell = Location(pieceLocation.rowIndex, columnIndex)
                    if (this.at(cell) !== null || cellIsThreatened(cell, playerColor)) {
                        blocked = true
                    }
                }

                if (!blocked) {
                    validCastlingPieceMoves.add(
                        Location(
                            pieceLocation.rowIndex, if (rookColumnIndex == 0) {
                                2
                            } else {
                                6
                            }
                        )
                    )
                }
            }
        }

        return validCastlingPieceMoves
    }
}

private enum class RegistrationResult {
    UNOCCUPIED_AND_VALID, OCCUPIED_BUT_VALID, INVALID,
}

private fun getNextCellInDirection(startCell: Location, direction: Direction): Location? {
    var rowIndex = startCell.rowIndex
    var columnIndex = startCell.columnIndex

    when (direction) {
        Direction.NORTH -> rowIndex--
        Direction.NORTHEAST -> {
            rowIndex--
            columnIndex++
        }

        Direction.EAST -> columnIndex++
        Direction.SOUTHEAST -> {
            rowIndex++
            columnIndex++
        }

        Direction.SOUTH -> rowIndex++
        Direction.SOUTHWEST -> {
            rowIndex++
            columnIndex--
        }

        Direction.WEST -> columnIndex--
        Direction.NORTHWEST -> {
            rowIndex--
            columnIndex--
        }
    }

    return attemptToCreateLocation(rowIndex, columnIndex)
}

enum class Direction {
    NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST
}

val defaultBoardState = listOf(
    listOf(
        Piece(PieceType.ROOK, PlayerColor.BLACK),
        Piece(PieceType.KNIGHT, PlayerColor.BLACK),
        Piece(PieceType.BISHOP, PlayerColor.BLACK),
        Piece(PieceType.QUEEN, PlayerColor.BLACK),
        Piece(PieceType.KING, PlayerColor.BLACK),
        Piece(PieceType.BISHOP, PlayerColor.BLACK),
        Piece(PieceType.KNIGHT, PlayerColor.BLACK),
        Piece(PieceType.ROOK, PlayerColor.BLACK),
    ),
    listOf(
        Piece(PieceType.PAWN, PlayerColor.BLACK),
        Piece(PieceType.PAWN, PlayerColor.BLACK),
        Piece(PieceType.PAWN, PlayerColor.BLACK),
        Piece(PieceType.PAWN, PlayerColor.BLACK),
        Piece(PieceType.PAWN, PlayerColor.BLACK),
        Piece(PieceType.PAWN, PlayerColor.BLACK),
        Piece(PieceType.PAWN, PlayerColor.BLACK),
        Piece(PieceType.PAWN, PlayerColor.BLACK),
    ),
    listOf(null, null, null, null, null, null, null, null),
    listOf(null, null, null, null, null, null, null, null),
    listOf(null, null, null, null, null, null, null, null),
    listOf(null, null, null, null, null, null, null, null),
    listOf(
        Piece(PieceType.PAWN, PlayerColor.WHITE),
        Piece(PieceType.PAWN, PlayerColor.WHITE),
        Piece(PieceType.PAWN, PlayerColor.WHITE),
        Piece(PieceType.PAWN, PlayerColor.WHITE),
        Piece(PieceType.PAWN, PlayerColor.WHITE),
        Piece(PieceType.PAWN, PlayerColor.WHITE),
        Piece(PieceType.PAWN, PlayerColor.WHITE),
        Piece(PieceType.PAWN, PlayerColor.WHITE),
    ),
    listOf(
        Piece(PieceType.ROOK, PlayerColor.WHITE),
        Piece(PieceType.KNIGHT, PlayerColor.WHITE),
        Piece(PieceType.BISHOP, PlayerColor.WHITE),
        Piece(PieceType.QUEEN, PlayerColor.WHITE),
        Piece(PieceType.KING, PlayerColor.WHITE),
        Piece(PieceType.BISHOP, PlayerColor.WHITE),
        Piece(PieceType.KNIGHT, PlayerColor.WHITE),
        Piece(PieceType.ROOK, PlayerColor.WHITE),
    ),
)
