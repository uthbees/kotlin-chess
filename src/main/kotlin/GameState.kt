import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import chessnuticons.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.math.abs

class GameViewModel : ViewModel() {
    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    fun movePiece(from: Location, to: Location) {
        if (!gameState.value.board.getValidPieceMoves(from, gameState.value.turnColor).contains(to)) {
            return
        }

        _gameState.update { currentState ->
            val newBoardState = currentState.board.state.map {
                it.toMutableList()
            }

            /**
             * Performs the basics of a piece move (the actual move itself). Also handles pawn
             * promotion if applicable.
             * */
            fun performBasicMove(basicMoveFrom: Location, basicMoveTo: Location) {
                val pieceToBasicMove = newBoardState[basicMoveFrom.rowIndex][basicMoveFrom.columnIndex]!!

                newBoardState[basicMoveTo.rowIndex][basicMoveTo.columnIndex] =
                    if (pieceCanPromote(pieceToBasicMove, basicMoveTo)) {
                        Piece(PieceType.QUEEN, pieceToBasicMove.color)
                    } else {
                        pieceToBasicMove.copy()
                    }
                newBoardState[basicMoveTo.rowIndex][basicMoveTo.columnIndex]!!.hasMoved = true
                newBoardState[basicMoveFrom.rowIndex][basicMoveFrom.columnIndex] = null
            }

            val pieceToMove = newBoardState[from.rowIndex][from.columnIndex]!!

            assert(newBoardState[to.rowIndex][to.columnIndex]?.type != PieceType.KING)
            assert(newBoardState[from.rowIndex][from.columnIndex] != null)

            // If we are performing en passant, take the appropriate pawn.
            if (pieceToMove.type == PieceType.PAWN && to == currentState.board.ghostPawn?.ghostLocation) {
                val takenPawnLocation = currentState.board.ghostPawn!!.realLocation
                newBoardState[takenPawnLocation.rowIndex][takenPawnLocation.columnIndex] = null
            }

            performBasicMove(from, to)

            // Move the appropriate rook if we're castling.
            if (pieceToMove.type == PieceType.KING) {
                val horizontalDistanceMoved = abs(to.columnIndex - from.columnIndex)
                assert(horizontalDistanceMoved in 0..2)
                if (horizontalDistanceMoved == 2) {
                    when (to.columnIndex) {
                        2 -> performBasicMove(Location(from.rowIndex, 0), Location(from.rowIndex, 3))
                        6 -> performBasicMove(Location(from.rowIndex, 7), Location(from.rowIndex, 5))
                        else -> assert(false)
                    }
                }
            }

            // Create a new board from the new board state. Note that the last board's ghost pawn is not copied
            // over (since it's no longer applicable).
            val board = Board(newBoardState)

            // Set the ghost pawn for en passant purposes if applicable (that is, if we just moved a pawn two spaces).
            if (pieceToMove.type == PieceType.PAWN && abs(to.rowIndex - from.rowIndex) == 2) {
                board.ghostPawn = Board.GhostPawn(Location((to.rowIndex + from.rowIndex) / 2, to.columnIndex), to)
            }

            currentState.copy(board = board)
        }

        nextTurn()
    }

    private fun nextTurn() {
        _gameState.update { currentState ->
            if (currentState.turnColor == PlayerColor.WHITE) {
                currentState.copy(turnColor = PlayerColor.BLACK)
            } else {
                currentState.copy(round = currentState.round + 1, turnColor = PlayerColor.WHITE)
            }
        }

        // Check for checkmate and stalemate.
        for ((rowIndex, row) in gameState.value.board.state.withIndex()) {
            for ((columnIndex, cell) in row.withIndex()) {
                if (cell != null && cell.color == gameState.value.turnColor) {
                    val pieceValidMoves = gameState.value.board.getValidPieceMoves(
                        Location(rowIndex, columnIndex), gameState.value.turnColor
                    )

                    if (pieceValidMoves.isNotEmpty()) {
                        // We have at least one valid move, so we can stop looking.
                        return
                    }
                }
            }
        }

        // We have no valid moves. :(
        if (gameState.value.board.inCheck(gameState.value.turnColor)) {
            // For checkmate, we turn back the clock by a turn so that it'll stay on the winning turn.
            when (gameState.value.turnColor) {
                PlayerColor.WHITE -> _gameState.update { currentState ->
                    currentState.copy(
                        gameStatus = GameStatus.BLACK_WON, turnColor = PlayerColor.BLACK, round = currentState.round - 1
                    )
                }

                PlayerColor.BLACK -> _gameState.update { currentState ->
                    currentState.copy(
                        gameStatus = GameStatus.WHITE_WON, turnColor = PlayerColor.WHITE
                    )

                }
            }
        } else {
            _gameState.update { currentState ->
                currentState.copy(
                    gameStatus = GameStatus.STALEMATE
                )
            }
        }
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

data class Piece(val type: PieceType, val color: PlayerColor, var hasMoved: Boolean = false) {
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

private fun pieceCanPromote(piece: Piece, location: Location): Boolean {
    val color = piece.color
    val rowIdx = location.rowIndex

    if (piece.type == PieceType.PAWN) {
        return ((color == PlayerColor.WHITE && rowIdx == 0) || (color == PlayerColor.BLACK && rowIdx == 7))
    }
    return false
}
