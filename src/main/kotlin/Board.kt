import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Board(gameState: GameState) {
    CenteredSquare {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.Blue), verticalArrangement = Arrangement.SpaceBetween
        ) {
            gameState.board.forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth().height(50.dp), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    row.forEach { cell ->
                        if (cell != null) {
                            Text(text = cell.type.toString(), modifier = Modifier.fillMaxSize())
                        } else {
                            Text(text = "empty", modifier = Modifier.fillMaxSize())
                        }
                    }
                }
            }

        }

    }
}

@Composable
private fun CenteredSquare(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxWithConstraints {
            val squareSize = minOf(constraints.maxWidth, constraints.maxHeight)
            Box(
                modifier = Modifier.size(squareSize.dp)
            ) { content() }
        }
    }
}
