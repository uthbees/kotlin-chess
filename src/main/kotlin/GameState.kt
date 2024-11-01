import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import chessnuticons.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    private fun nextTurn() {
        _gameState.update { currentState ->
            if (currentState.turnColor == PlayerColor.WHITE) {
                currentState.copy(turnColor = PlayerColor.BLACK)
            } else {
                currentState.copy(round = currentState.round + 1, turnColor = PlayerColor.WHITE)
            }
        }
    }

    /**
     * Returns a list of all the current valid moves of the piece at a given location.
     * */
    fun getValidPieceMoves(pieceLocation: Location): List<Location> {
        val board = gameState.value.board
        val piece = board.at(pieceLocation) ?: return emptyList()

        if (piece.color != gameState.value.turnColor) {
            return emptyList()
        }

        val validPieceMoves = mutableListOf<Location>()

        fun registerReachablePlace(rowIndex: Int, columnIndex: Int) {
            val cell = attemptToCreateLocation(rowIndex, columnIndex) ?: return

            if (piece.color != board.at(cell)?.color) {
                validPieceMoves.add(cell)
            }
        }

        fun registerBlockableLine(pieceLocation: Location, direction: Direction) {
            var blocked = false;

            var currentCell: Location? = getNextCellInDirection(pieceLocation, direction)

            while (!blocked && currentCell != null) {
                if (piece.color != board.at(currentCell)?.color) {
                    validPieceMoves.add(currentCell)
                }

                if (board.at(currentCell) != null) {
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
                if (piece.color == PlayerColor.WHITE) {
                    registerReachablePlace(pieceLocation.rowIndex - 1, pieceLocation.columnIndex)
                } else {
                    registerReachablePlace(pieceLocation.rowIndex + 1, pieceLocation.columnIndex)
                }
            }
        }

        return validPieceMoves;
    }
}

data class GameState(
    val round: Int = 1,
    val turnColor: PlayerColor = PlayerColor.WHITE,
    val gameStatus: GameStatus = GameStatus.PLAYING,
    val board: Board = Board(),
)

enum class PlayerColor {
    BLACK, WHITE
}

enum class GameStatus {
    PLAYING, WHITE_WON, BLACK_WON, STALEMATE,
}

enum class PieceType {
    KING, QUEEN, ROOK, KNIGHT, BISHOP, PAWN
}

enum class Direction {
    NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST
}

class Board(var state: List<List<Piece?>> = defaultBoardState.toMutableList()) {
    /**
     * A utility function to get the piece at a given location.
     * */
    fun at(location: Location): Piece? {
        return state[location.rowIndex][location.columnIndex]
    }
}

class Piece(val type: PieceType, val color: PlayerColor) {
    fun getIcon(): ImageVector {
        return when (color) {
            PlayerColor.BLACK -> when (type) {
                PieceType.KING -> ChessnutIcons.Bk
                PieceType.QUEEN -> ChessnutIcons.Bq
                PieceType.ROOK -> ChessnutIcons.Br
                PieceType.KNIGHT -> ChessnutIcons.Bn
                PieceType.BISHOP -> ChessnutIcons.Bb
                PieceType.PAWN -> ChessnutIcons.Bp
            }

            PlayerColor.WHITE -> when (type) {
                PieceType.KING -> ChessnutIcons.Wk
                PieceType.QUEEN -> ChessnutIcons.Wq
                PieceType.ROOK -> ChessnutIcons.Wr
                PieceType.KNIGHT -> ChessnutIcons.Wn
                PieceType.BISHOP -> ChessnutIcons.Wb
                PieceType.PAWN -> ChessnutIcons.Wp
            }
        }
    }
}

data class Location(val rowIndex: Int, val columnIndex: Int) {
    init {
        assert(rowIndex in 0..7)
        assert(columnIndex in 0..7)
    }
}

fun attemptToCreateLocation(rowIndex: Int, columnIndex: Int): Location? {
    if (rowIndex !in 0..7 || columnIndex !in 0..7) {
        return null
    }
    return Location(rowIndex, columnIndex)
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
