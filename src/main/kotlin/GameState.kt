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

    fun movePiece(from: Location, to: Location) {
        if (!gameState.value.board.getValidPieceMoves(from, gameState.value.turnColor).contains(to)) {
            return
        }

        _gameState.update { currentState ->
            val newBoardState = currentState.board.state.map {
                it.toMutableList()
            }

            assert(newBoardState[to.rowIndex][to.columnIndex]?.type != PieceType.KING)

            newBoardState[to.rowIndex][to.columnIndex] = newBoardState[from.rowIndex][from.columnIndex]?.copy()
            newBoardState[to.rowIndex][to.columnIndex]!!.hasMoved = true
            newBoardState[from.rowIndex][from.columnIndex] = null

            currentState.copy(board = Board(newBoardState))
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
