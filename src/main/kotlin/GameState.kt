import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class GameState(val round: Int = 1, val turnColor: PlayerColor = PlayerColor.WHITE)

class GameViewModel : ViewModel() {
    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    fun nextTurn() {
        _gameState.update { currentState ->
            if (currentState.turnColor == PlayerColor.WHITE) {
                currentState.copy(turnColor = PlayerColor.BLACK)
            } else {
                currentState.copy(round = currentState.round + 1, turnColor = PlayerColor.WHITE)
            }
        }
    }
}

enum class PlayerColor {
    BLACK, WHITE
}

/*
Game state: White's turn, black's turn, white won, black won
Turn number
Track last capture/pawn advancement somewhere

*/
