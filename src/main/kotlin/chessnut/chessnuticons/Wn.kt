package chessnuticons

import ChessnutIcons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeCap.Companion.Square
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChessnutIcons.Wn: ImageVector
    get() {
        if (_wn != null) {
            return _wn!!
        }
        _wn = Builder(name = "Wn", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp, viewportWidth
                = 800.0f, viewportHeight = 800.0f).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 29.16f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(645.254f, 692.2f)
                verticalLineTo(280.6f)
                curveToRelative(-57.2f, -41.8f, -142.3f, -85.8f, -196.6f, -98.1f)
                curveToRelative(-42.6f, -9.7f, -101.3f, -2.1f, -148.6f, 13.2f)
                curveToRelative(-13.3f, -34.9f, -48.0f, -58.6f, -81.5f, -60.4f)
                curveToRelative(6.3f, 29.6f, 5.9f, 74.3f, 24.3f, 97.7f)
                curveToRelative(-7.0f, 16.2f, -32.1f, 69.4f, -48.7f, 119.3f)
                verticalLineToRelative(39.4f)
                curveToRelative(-13.9f, 59.1f, -34.9f, 166.2f, -43.4f, 212.8f)
                lineToRelative(120.9f, 51.5f)
                lineToRelative(22.4f, -58.1f)
                curveToRelative(15.2f, -22.7f, 45.7f, -60.9f, 65.1f, -78.2f)
                curveToRelative(24.4f, -10.3f, 55.8f, -29.4f, 66.6f, -59.2f)
                curveToRelative(14.0f, -38.4f, 6.3f, -84.3f, -10.5f, -119.9f)
                curveToRelative(31.0f, 30.2f, 50.0f, 77.0f, 50.0f, 127.8f)
                curveToRelative(0.0f, 68.1f, -38.1f, 145.9f, -104.7f, 223.7f)
                horizontalLineToRelative(284.7f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 9.169f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(179.754f, 574.8f)
                curveToRelative(19.4f, -10.9f, 33.9f, 3.8f, 22.4f, 25.2f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 0.952f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(231.454f, 357.9f)
                curveToRelative(-6.9f, 9.5f, -0.6f, 29.3f, 6.0f, 34.5f)
                curveToRelative(4.5f, -0.6f, 14.1f, -4.4f, 18.6f, -8.0f)
                lineToRelative(21.5f, -24.9f)
                lineToRelative(-4.5f, -3.7f)
                curveToRelative(-8.8f, -0.1f, -30.7f, -0.1f, -41.6f, 2.1f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFFFFF)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 23.76f, strokeLineCap = Square, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(320.054f, 186.0f)
                curveToRelative(-12.5f, -17.9f, -9.9f, -49.7f, 7.0f, -75.1f)
                curveToRelative(28.2f, 14.3f, 39.7f, 47.4f, 35.1f, 70.6f)
            }
        }
        .build()
        return _wn!!
    }

private var _wn: ImageVector? = null
