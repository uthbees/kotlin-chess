package chessnuticons

import ChessnutIcons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChessnutIcons.Bn: ImageVector
    get() {
        if (_bn != null) {
            return _bn!!
        }
        _bn = Builder(name = "Bn", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp, viewportWidth
                = 800.0f, viewportHeight = 800.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(137.8f, 605.9f)
                curveToRelative(8.0f, -43.0f, 28.9f, -151.0f, 43.3f, -212.0f)
                verticalLineToRelative(-40.0f)
                lineToRelative(0.5f, -1.6f)
                curveToRelative(13.9f, -41.9f, 33.6f, -85.5f, 44.1f, -109.0f)
                curveToRelative(1.0f, -2.2f, 1.8f, -4.0f, 2.6f, -5.7f)
                curveToRelative(-11.9f, -19.0f, -15.2f, -45.7f, -18.4f, -69.4f)
                curveToRelative(-1.3f, -9.9f, -2.5f, -19.3f, -4.2f, -27.3f)
                lineToRelative(-2.9f, -13.7f)
                lineToRelative(14.0f, 0.8f)
                curveToRelative(33.7f, 1.7f, 66.1f, 22.4f, 83.6f, 51.9f)
                curveToRelative(-5.9f, -21.6f, -0.9f, -49.4f, 14.4f, -72.1f)
                lineToRelative(5.8f, -8.7f)
                lineToRelative(9.4f, 4.8f)
                curveToRelative(27.5f, 13.9f, 41.8f, 43.2f, 42.6f, 68.7f)
                curveToRelative(10.7f, -1.1f, 21.2f, -1.6f, 31.1f, -1.6f)
                curveToRelative(16.7f, 0.0f, 32.0f, 1.5f, 45.3f, 4.5f)
                curveToRelative(53.0f, 12.0f, 139.4f, 55.0f, 200.9f, 99.9f)
                lineToRelative(4.4f, 3.2f)
                verticalLineToRelative(428.3f)
                horizontalLineTo(334.8f)
                lineTo(350.0f, 689.0f)
                curveToRelative(66.7f, -78.1f, 102.1f, -153.0f, 102.1f, -216.9f)
                curveToRelative(0.0f, -22.0f, -3.9f, -43.7f, -11.1f, -63.5f)
                curveToRelative(1.4f, 21.1f, -1.0f, 41.3f, -7.5f, 59.1f)
                curveToRelative(-12.6f, 34.9f, -49.1f, 55.3f, -70.8f, 64.7f)
                curveToRelative(-17.7f, 16.2f, -46.0f, 51.2f, -61.3f, 74.0f)
                lineToRelative(-25.9f, 67.4f)
                lineToRelative(-139.1f, -59.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFFf2f2f2)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(177.4f, 578.1f)
                curveToRelative(19.4f, -10.9f, 33.9f, 3.8f, 22.4f, 25.2f)
                close()
                moveTo(229.0f, 361.1f)
                curveToRelative(-6.9f, 9.5f, -0.6f, 29.3f, 6.0f, 34.5f)
                curveToRelative(4.5f, -0.6f, 14.1f, -4.4f, 18.6f, -8.0f)
                lineToRelative(21.5f, -24.9f)
                lineToRelative(-4.5f, -3.7f)
                curveToRelative(-8.7f, -0.1f, -30.7f, -0.1f, -41.6f, 2.1f)
                close()
                moveTo(319.8f, 200.3f)
                lineToRelative(0.6f, -2.9f)
                curveToRelative(31.1f, -5.1f, 73.0f, -6.0f, 97.3f, -6.0f)
                curveToRelative(45.7f, 0.0f, 148.0f, 58.8f, 209.5f, 104.1f)
                verticalLineToRelative(55.1f)
                curveToRelative(-45.0f, -43.5f, -141.2f, -118.8f, -196.3f, -135.8f)
                curveToRelative(-37.2f, -11.5f, -74.1f, -15.7f, -111.1f, -14.5f)
                close()
            }
        }
        .build()
        return _bn!!
    }

private var _bn: ImageVector? = null
