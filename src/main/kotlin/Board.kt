import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Board(gameState: GameState) {
    BoardWrapper {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            gameState.board.forEachIndexed { rowIndex, row ->
                Row(
                    modifier = Modifier.fillMaxWidth().weight(1f)
                ) {
                    row.forEachIndexed { columnIndex, piece ->
                        var modifier = Modifier.fillMaxSize().weight(1f)
                        modifier = if ((rowIndex + columnIndex) % 2 == 0) {
                            // Light squares
                            modifier.background(Color(0xfff1cc86))
                        } else {
                            // Dark squares
                            modifier.background(Color(0xff895c39))
                        }

                        if (piece == null) {
                            Box(modifier = modifier)
                        } else {
                            Image(
                                piece.getIcon(),
                                contentDescription = "",
                                modifier = modifier,
                            )
                        }
                    }
                }
            }

        }

    }
}

/**
 * A centered square to wrap the board in.
 */
@Composable
private fun BoardWrapper(content: @Composable () -> Unit) {
    val borderWidth = 5.dp;

    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxWithConstraints(modifier = Modifier.border(borderWidth, Color.Black)) {
            val squareSize = minOf(constraints.maxWidth, constraints.maxHeight)
            Box(
                modifier = Modifier.size(squareSize.dp).padding(borderWidth),
            ) { content() }
        }
    }
}
