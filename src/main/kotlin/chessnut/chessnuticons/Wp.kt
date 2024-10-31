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

public val ChessnutIcons.Wp: ImageVector
    get() {
        if (_wp != null) {
            return _wp!!
        }
        _wp = Builder(name = "Wp", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp, viewportWidth
                = 800.0f, viewportHeight = 800.0f).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 30.24f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(497.9f, 240.0f)
                curveToRelative(0.0f, 53.6f, -44.0f, 93.9f, -98.1f, 93.9f)
                reflectiveCurveToRelative(-98.1f, -40.3f, -98.1f, -93.9f)
                reflectiveCurveToRelative(44.0f, -93.9f, 98.1f, -93.9f)
                curveToRelative(54.2f, 0.1f, 98.1f, 40.4f, 98.1f, 93.9f)
                close()
                moveTo(526.4f, 337.6f)
                verticalLineToRelative(55.3f)
                curveToRelative(-30.2f, 3.0f, -42.8f, 12.1f, -42.8f, 28.0f)
                curveToRelative(0.0f, 56.9f, 36.0f, 123.4f, 109.1f, 187.9f)
                verticalLineToRelative(60.9f)
                curveToRelative(0.0f, 17.4f, -87.5f, 30.8f, -192.7f, 30.8f)
                reflectiveCurveToRelative(-192.7f, -13.4f, -192.7f, -30.8f)
                lineToRelative(-0.1f, -60.6f)
                curveToRelative(73.1f, -64.5f, 108.1f, -131.1f, 108.1f, -188.0f)
                curveToRelative(0.0f, -15.9f, -13.6f, -25.2f, -43.8f, -28.2f)
                verticalLineToRelative(-55.3f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 16.2f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(207.2f, 608.0f)
                curveToRelative(0.0f, 17.4f, 87.5f, 30.3f, 192.7f, 30.3f)
                reflectiveCurveToRelative(192.6f, -12.9f, 192.6f, -30.2f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 14.04f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveToRelative(272.6f, 386.7f)
                horizontalLineToRelative(252.7f)
            }
        }
        .build()
        return _wp!!
    }

private var _wp: ImageVector? = null
