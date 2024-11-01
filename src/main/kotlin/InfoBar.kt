import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoBar(gameState: GameState) {
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

        Text(
            textContent,
            fontSize = 20.sp,
            maxLines = 1,
            modifier = Modifier.align(Alignment.Center).background(color = Color.White)
                .border(5.dp, Color.Black).padding(10.dp)
        )
    }
}
