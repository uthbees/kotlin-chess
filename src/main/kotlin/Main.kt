import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App(gameViewModel: GameViewModel = GameViewModel()) {
    val gameState by gameViewModel.gameState.collectAsState()

    MaterialTheme {
        Button(onClick = { gameViewModel.nextTurn() }) {
            Text("next turn")
        }
        Board(gameState)
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
