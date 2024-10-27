import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Board(gameState: GameState) {
    Button(onClick = { gameState.nextTurn() }) {
        Text("turn: ${gameState.round}")
    }
}
