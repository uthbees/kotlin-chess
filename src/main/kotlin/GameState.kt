import androidx.lifecycle.ViewModel
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
}

data class GameState(
    val round: Int = 1,
    val turnColor: PlayerColor = PlayerColor.WHITE,
    val gameStatus: GameStatus = GameStatus.PLAYING,
    val board: List<List<Piece?>> = listOf(
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
)

enum class PlayerColor {
    BLACK, WHITE
}

enum class GameStatus {
    PLAYING, WHITE_WON, BLACK_WON, STALEMATE,
}

class Piece(val type: PieceType, val color: PlayerColor) {
}

enum class PieceType {
    KING, QUEEN, ROOK, KNIGHT, BISHOP, PAWN
}
