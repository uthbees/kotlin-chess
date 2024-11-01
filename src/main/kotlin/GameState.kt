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
        val piece = gameState.value.board.at(pieceLocation) ?: return emptyList()

        if (piece.color != gameState.value.turnColor) {
            return emptyList()
        }

        val validPieceMoves = mutableListOf<Location>()

        fun registerPotentialMove(rowIndex: Int, columnIndex: Int) {
            validPieceMoves.add(Location(rowIndex, columnIndex))
        }

        when (piece.type) {
            PieceType.KING -> {
                registerPotentialMove(0, 0)
            }

            else -> {}
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

class Board {
    lateinit var state: List<List<Piece?>>

    /**
     * Resets the board to its initial state.
     * */
    fun reset() {
        state = listOf(
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
    }

    /**
     * A utility function to get the piece at a given location.
     * */
    fun at(location: Location): Piece? {
        return state[location.rowIndex][location.columnIndex]
    }

    init {
        reset()
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

enum class PieceType {
    KING, QUEEN, ROOK, KNIGHT, BISHOP, PAWN
}

data class Location(val rowIndex: Int, val columnIndex: Int) {
    init {
        assert(rowIndex in 0..7)
        assert(columnIndex in 0..7)
    }
}
