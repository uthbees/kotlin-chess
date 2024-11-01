import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.awt.Dimension

@Composable
@Preview
fun App(gameViewModel: GameViewModel = GameViewModel()) {
    val gameState by gameViewModel.gameState.collectAsState()

    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize().background(color = Color(0xff2e4022))) {
            InfoBar(gameState)
            Board(gameState,
                { pieceLocation: Location -> gameViewModel.getValidPieceMoves(pieceLocation) },
                { from: Location, to: Location -> gameViewModel.movePiece(from, to) })

        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Chess") {
        window.minimumSize = Dimension(500, 500)
        App()
    }
}
