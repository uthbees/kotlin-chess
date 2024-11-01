import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BoardUi(
    gameState: GameState, movePiece: (from: Location, to: Location) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    var selectedCell: Location? by remember { mutableStateOf(null) }
    val validMoves = derivedStateOf {
        if (selectedCell != null) gameState.board.getValidPieceMoves(
            selectedCell!!, gameState.turnColor
        ) else emptyList()
    }
    val inCheck = derivedStateOf { gameState.board.inCheck(gameState.turnColor) }

    fun selectCell(location: Location) {
        if (gameState.gameStatus != GameStatus.PLAYING) {
            return
        }

        if (validMoves.value.contains(location)) {
            assert(selectedCell != null)
            movePiece(selectedCell!!, location)
        }

        selectedCell = if (selectedCell == location) {
            null
        } else {
            val pieceInCell = gameState.board.at(location)

            if (pieceInCell != null && pieceInCell.color == gameState.turnColor) {
                location
            } else {
                null
            }
        }
    }

    BoardWrapper {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            gameState.board.state.forEachIndexed { rowIndex, row ->
                Row(
                    modifier = Modifier.fillMaxWidth().weight(1f)
                ) {
                    row.forEachIndexed { columnIndex, piece ->
                        val cell = Location(rowIndex, columnIndex)

                        var modifier = Modifier.fillMaxSize().weight(1f).clickable(
                            interactionSource = interactionSource, indication = null
                        ) {
                            selectCell(cell)
                        }

                        modifier =
                            if (inCheck.value && gameState.board.at(cell)?.type == PieceType.KING && gameState.board.at(
                                    cell
                                )?.color == gameState.turnColor
                            ) {
                                modifier.background(Color(0xffd13d32))
                            } else if ((rowIndex + columnIndex) % 2 == 0) {
                                // Light squares
                                modifier.background(Color(0xfff1cc86))
                            } else {
                                // Dark squares
                                modifier.background(Color(0xff895c39))
                            }

                        if (selectedCell?.rowIndex == rowIndex && selectedCell?.columnIndex == columnIndex) {
                            modifier = modifier.border(4.dp, Color(0xff7dab5f))
                        }

                        Box(modifier = modifier) {
                            if (piece != null) {
                                Image(piece.getIcon(), contentDescription = "")
                            }

                            if (validMoves.value.any { it == cell }) {
                                Box(
                                    modifier = Modifier.fillMaxSize(fraction = 0.5f)
                                        .background(color = Color(0xb0222222), shape = CircleShape)
                                        .align(Alignment.Center)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * A centered square to wrap the board in.
 * */
@Composable
private fun BoardWrapper(content: @Composable () -> Unit) {
    val borderWidth = 5.dp

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
