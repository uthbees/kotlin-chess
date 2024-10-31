import androidx.compose.ui.graphics.vector.ImageVector
import chessnuticons.Bb
import chessnuticons.Bk
import chessnuticons.Bn
import chessnuticons.Bp
import chessnuticons.Bq
import chessnuticons.Br
import chessnuticons.Wb
import chessnuticons.Wk
import chessnuticons.Wn
import chessnuticons.Wp
import chessnuticons.Wq
import chessnuticons.Wr
import kotlin.collections.List as ____KtList

public object ChessnutIcons

private var __AllIcons: ____KtList<ImageVector>? = null

public val ChessnutIcons.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Bp, Wr, Wp, Bk, Wb, Br, Wk, Bb, Wq, Wn, Bq, Bn)
    return __AllIcons!!
  }
