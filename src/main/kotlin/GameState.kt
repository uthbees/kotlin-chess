import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class GameState(val round: Int = 1, val turnColor: PlayerColor = PlayerColor.WHITE)

class GameStateViewModel : ViewModel() {
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

fun manageGameStateViewModel() {
    val viewModel = viewModel<GameStateViewModel>()
    // TODO
    val gameState by viewModel.gameState.collectAsStateWithLifecycle()
}


//@Composable
//fun storeGameState(): GameState {
//    val round by remember { mutableStateOf(0) }
//    val turnColor by remember { mutableStateOf(PlayerColor.WHITE) }
//
//    // TODO: This is not working. Fix it.
//    return GameState(round, { nextTurn(round, turnColor) })
//}

enum class PlayerColor {
    BLACK, WHITE
}

//private fun nextTurn(round: Int, turnColor: PlayerColor): Pair<Int, PlayerColor> {
//    return if (turnColor == PlayerColor.WHITE) {
//        Pair(round, PlayerColor.BLACK)
//    } else {
//        Pair(round + 1, PlayerColor.WHITE)
//    }
//}

/*
Game state: White's turn, black's turn, white won, black won
Turn number
Track last capture/pawn advancement somewhere

*/

//class Turn {
//    var round = 1
//    var color: Color = Color.WHITE
//
//    fun next() {
//        if (color == Color.WHITE) {
//            color = Color.BLACK
//        } else {
//            color = Color.WHITE
//            round++
//        }
//    }
//}
