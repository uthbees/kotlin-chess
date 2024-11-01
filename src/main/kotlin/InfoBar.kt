import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoBar(gameState: GameState, resetGame: () -> Unit) {
    Box(modifier = Modifier.fillMaxHeight(0.1f).fillMaxWidth()) {
        var textContent = "Round ${gameState.round} - "

        textContent += when (gameState.turnColor) {
            PlayerColor.WHITE -> "White"
            PlayerColor.BLACK -> "Black"
        }

        textContent += when (gameState.gameStatus) {
            GameStatus.PLAYING -> ""
            GameStatus.WHITE_WON -> " | White won!"
            GameStatus.BLACK_WON -> " | Black won!"
            GameStatus.STALEMATE -> " | Stalemate!"
        }

        InfoBarTextbox(text = textContent, modifier = Modifier.align(Alignment.Center))
        Button(
            onClick = resetGame,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier.align(Alignment.CenterEnd).padding(end = 10.dp)
        ) {
            Text("Reset")
        }
    }
}

@Composable
private fun InfoBarTextbox(text: String = "", modifier: Modifier = Modifier) {
    Text(
        text,
        fontSize = 20.sp,
        maxLines = 1,
        modifier = modifier.background(color = Color.White).border(5.dp, Color.Black).padding(10.dp)
    )
}
