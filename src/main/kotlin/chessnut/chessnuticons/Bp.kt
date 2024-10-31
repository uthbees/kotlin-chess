package chessnuticons

import ChessnutIcons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChessnutIcons.Bp: ImageVector
    get() {
        if (_bp != null) {
            return _bp!!
        }
        _bp = Builder(name = "Bp", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp, viewportWidth
                = 800.0f, viewportHeight = 800.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(489.3f, 418.3f)
                curveToRelative(0.1f, -17.0f, 12.0f, -25.1f, 65.1f, -29.9f)
                verticalLineTo(330.0f)
                horizontalLineToRelative(-90.7f)
                curveToRelative(32.0f, -19.5f, 52.8f, -53.5f, 52.8f, -92.9f)
                curveToRelative(0.0f, -61.9f, -51.3f, -110.4f, -116.7f, -110.4f)
                reflectiveCurveToRelative(-116.7f, 48.5f, -116.7f, 110.4f)
                curveToRelative(0.0f, 39.4f, 20.7f, 73.3f, 52.8f, 92.9f)
                horizontalLineToRelative(-91.4f)
                verticalLineToRelative(58.4f)
                curveToRelative(53.7f, 4.8f, 65.2f, 12.9f, 65.2f, 29.8f)
                curveToRelative(0.0f, 60.7f, -37.6f, 131.5f, -115.5f, 200.1f)
                lineToRelative(0.1f, 64.0f)
                curveToRelative(0.0f, 18.6f, 93.2f, 32.0f, 205.3f, 32.0f)
                reflectiveCurveToRelative(205.4f, -13.5f, 205.4f, -32.0f)
                lineToRelative(0.1f, -64.0f)
                curveToRelative(-77.9f, -68.5f, -115.8f, -139.4f, -115.8f, -200.0f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFf2f2f2)),
                    strokeLineWidth = 19.44f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(232.1f, 627.2f)
                curveToRelative(0.0f, 13.7f, 76.0f, 25.7f, 167.6f, 25.7f)
                curveToRelative(91.5f, 0.0f, 167.4f, -11.0f, 167.4f, -24.6f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFf2f2f2)),
                    strokeLineWidth = 16.2f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(400.9f, 150.3f)
                curveToRelative(-24.0f, -0.2f, -47.6f, 8.6f, -66.3f, 27.3f)
                curveToRelative(-26.7f, 26.8f, -32.5f, 63.2f, -20.0f, 95.3f)
            }
        }
        .build()
        return _bp!!
    }

private var _bp: ImageVector? = null
