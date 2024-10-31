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

public val ChessnutIcons.Wq: ImageVector
    get() {
        if (_wq != null) {
            return _wq!!
        }
        _wq = Builder(name = "Wq", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp, viewportWidth
                = 800.0f, viewportHeight = 800.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 20.52f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(401.1f, 704.4f)
                curveToRelative(-62.0f, 0.0f, -120.5f, -5.5f, -164.8f, -15.4f)
                curveToRelative(-49.6f, -11.1f, -74.1f, -25.8f, -75.0f, -44.7f)
                lineToRelative(-10.2f, -54.0f)
                verticalLineToRelative(-0.9f)
                curveToRelative(0.0f, -5.4f, 1.6f, -13.2f, 8.6f, -21.4f)
                curveToRelative(-8.0f, -46.5f, -25.9f, -125.2f, -44.6f, -195.5f)
                curveToRelative(-18.4f, -6.9f, -30.8f, -24.5f, -30.8f, -44.6f)
                curveToRelative(0.0f, -26.4f, 21.4f, -47.7f, 47.7f, -47.7f)
                reflectiveCurveToRelative(47.7f, 21.4f, 47.7f, 47.7f)
                curveToRelative(0.0f, 11.1f, -3.7f, 21.5f, -10.6f, 29.9f)
                curveTo(190.2f, 424.9f, 216.0f, 494.5f, 234.0f, 533.0f)
                lineToRelative(5.3f, -1.3f)
                curveToRelative(-0.5f, -55.3f, -9.1f, -164.3f, -20.6f, -261.6f)
                curveToRelative(-18.6f, -8.0f, -31.0f, -26.6f, -31.0f, -47.1f)
                curveToRelative(0.0f, -28.3f, 23.0f, -51.3f, 51.3f, -51.3f)
                reflectiveCurveToRelative(51.3f, 23.0f, 51.3f, 51.3f)
                curveToRelative(0.0f, 13.8f, -5.4f, 26.7f, -15.0f, 36.3f)
                curveToRelative(17.9f, 93.5f, 47.7f, 211.6f, 65.3f, 258.9f)
                lineToRelative(5.4f, -0.3f)
                curveToRelative(8.6f, -66.0f, 19.4f, -184.5f, 24.6f, -294.5f)
                curveToRelative(-14.9f, -10.0f, -23.8f, -26.6f, -23.8f, -44.6f)
                curveToRelative(0.0f, -29.8f, 24.2f, -54.0f, 54.0f, -54.0f)
                reflectiveCurveToRelative(54.0f, 24.2f, 54.0f, 54.0f)
                curveToRelative(0.0f, 18.0f, -8.9f, 34.6f, -23.5f, 44.6f)
                curveToRelative(5.2f, 110.1f, 16.0f, 228.5f, 24.6f, 294.5f)
                lineToRelative(5.4f, 0.3f)
                curveToRelative(17.6f, -47.3f, 47.4f, -165.3f, 65.3f, -258.9f)
                curveToRelative(-9.6f, -9.6f, -15.0f, -22.5f, -15.0f, -36.3f)
                curveToRelative(0.0f, -28.3f, 23.0f, -51.3f, 51.3f, -51.3f)
                reflectiveCurveToRelative(51.3f, 23.0f, 51.3f, 51.3f)
                curveToRelative(0.0f, 20.6f, -12.4f, 39.1f, -31.0f, 47.1f)
                curveToRelative(-11.6f, 97.3f, -20.2f, 206.3f, -20.6f, 261.6f)
                lineToRelative(5.3f, 1.3f)
                curveToRelative(18.0f, -38.4f, 43.8f, -108.1f, 64.9f, -175.2f)
                curveToRelative(-6.9f, -8.4f, -10.6f, -18.9f, -10.6f, -29.9f)
                curveToRelative(0.0f, -26.4f, 21.4f, -47.7f, 47.7f, -47.7f)
                reflectiveCurveToRelative(47.7f, 21.4f, 47.7f, 47.7f)
                curveToRelative(0.0f, 20.1f, -12.4f, 37.7f, -30.8f, 44.6f)
                curveToRelative(-18.7f, 70.3f, -36.5f, 148.9f, -44.6f, 195.5f)
                curveToRelative(5.7f, 6.7f, 8.6f, 13.8f, 8.6f, 21.3f)
                verticalLineToRelative(0.9f)
                lineToRelative(-10.3f, 54.3f)
                curveToRelative(-1.2f, 18.9f, -25.7f, 33.5f, -75.0f, 44.6f)
                curveToRelative(-43.8f, 9.8f, -102.3f, 15.3f, -164.4f, 15.3f)
                close()
                moveTo(211.7f, 613.7f)
                curveToRelative(1.4f, 3.0f, 13.7f, 12.4f, 54.6f, 20.3f)
                curveToRelative(36.5f, 7.0f, 84.2f, 11.0f, 134.6f, 11.0f)
                curveToRelative(50.3f, 0.0f, 98.2f, -3.9f, 134.6f, -11.0f)
                curveToRelative(40.9f, -8.0f, 53.4f, -17.3f, 54.6f, -20.3f)
                curveToRelative(-1.4f, -3.0f, -13.7f, -12.4f, -54.6f, -20.3f)
                curveToRelative(-36.5f, -7.0f, -84.2f, -11.0f, -134.6f, -11.0f)
                curveToRelative(-50.3f, 0.0f, -98.2f, 3.9f, -134.6f, 11.0f)
                curveToRelative(-40.8f, 7.9f, -53.1f, 17.3f, -54.6f, 20.3f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFFFFF)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 16.2f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(592.9f, 607.6f)
                curveToRelative(-41.8f, 13.8f, -112.3f, 23.2f, -191.8f, 23.2f)
                curveToRelative(-80.4f, 0.0f, -148.9f, -9.5f, -190.6f, -23.5f)
                curveTo(197.0f, 610.8f, 171.0f, 628.4f, 171.0f, 643.0f)
                curveToRelative(0.0f, 28.5f, 103.0f, 51.6f, 230.0f, 51.6f)
                reflectiveCurveToRelative(230.0f, -23.1f, 230.0f, -51.6f)
                curveToRelative(0.1f, -14.2f, -24.4f, -31.7f, -38.1f, -35.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFFFFF)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 17.28f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(401.1f, 591.4f)
                curveToRelative(127.1f, 0.0f, 230.1f, 23.1f, 230.1f, 51.6f)
                lineToRelative(10.2f, -60.3f)
                curveToRelative(0.0f, -6.3f, -3.2f, -12.3f, -9.4f, -18.1f)
                curveToRelative(7.5f, -44.9f, 26.1f, -121.9f, 47.0f, -199.9f)
                curveToRelative(16.6f, -4.0f, 29.1f, -19.0f, 29.1f, -36.9f)
                curveToRelative(0.0f, -21.0f, -17.0f, -38.0f, -38.0f, -38.0f)
                curveToRelative(-21.1f, 0.0f, -38.0f, 17.0f, -38.0f, 38.0f)
                curveToRelative(0.0f, 10.8f, 4.5f, 20.6f, 11.8f, 27.5f)
                curveToRelative(-20.8f, 67.0f, -50.1f, 141.4f, -70.4f, 182.4f)
                lineToRelative(-20.4f, -4.9f)
                curveToRelative(-0.3f, -54.2f, 9.2f, -167.8f, 21.5f, -269.9f)
                curveToRelative(17.4f, -5.0f, 30.2f, -21.0f, 30.2f, -40.0f)
                curveToRelative(0.0f, -23.0f, -18.6f, -41.6f, -41.6f, -41.6f)
                reflectiveCurveTo(521.5f, 200.0f, 521.5f, 223.0f)
                curveToRelative(0.0f, 13.3f, 6.3f, 25.1f, 15.9f, 32.7f)
                curveToRelative(-18.0f, 95.8f, -51.2f, 221.4f, -69.4f, 266.1f)
                lineToRelative(-20.4f, -1.3f)
                curveToRelative(-9.1f, -66.5f, -20.8f, -188.6f, -26.0f, -302.6f)
                curveToRelative(14.1f, -7.5f, 23.8f, -22.1f, 23.8f, -39.2f)
                curveToRelative(0.0f, -24.4f, -19.9f, -44.3f, -44.3f, -44.3f)
                reflectiveCurveToRelative(-44.3f, 19.9f, -44.3f, 44.3f)
                curveToRelative(0.0f, 17.1f, 9.6f, 31.9f, 23.8f, 39.2f)
                curveToRelative(-5.1f, 114.0f, -16.8f, 236.1f, -26.0f, 302.6f)
                lineToRelative(-20.4f, 1.3f)
                curveToRelative(-18.1f, -44.7f, -51.4f, -170.3f, -69.4f, -266.1f)
                curveToRelative(9.7f, -7.6f, 15.9f, -19.4f, 15.9f, -32.7f)
                curveToRelative(0.0f, -23.0f, -18.6f, -41.6f, -41.6f, -41.6f)
                reflectiveCurveTo(197.3f, 200.0f, 197.3f, 223.0f)
                curveToRelative(0.0f, 19.0f, 12.7f, 35.0f, 30.2f, 40.0f)
                curveToRelative(12.3f, 102.0f, 21.8f, 215.5f, 21.5f, 269.8f)
                lineToRelative(-20.4f, 4.9f)
                curveToRelative(-20.3f, -41.1f, -49.7f, -115.5f, -70.4f, -182.4f)
                curveToRelative(7.2f, -6.9f, 11.8f, -16.6f, 11.8f, -27.5f)
                curveToRelative(0.0f, -21.0f, -17.0f, -38.0f, -38.0f, -38.0f)
                curveToRelative(-21.1f, 0.0f, -38.0f, 17.0f, -38.0f, 38.0f)
                curveToRelative(0.0f, 17.9f, 12.4f, 32.9f, 29.1f, 36.9f)
                curveToRelative(20.8f, 78.0f, 39.5f, 155.0f, 47.0f, 199.9f)
                curveToRelative(-6.0f, 5.7f, -9.4f, 11.8f, -9.4f, 18.1f)
                lineToRelative(10.2f, 60.3f)
                curveToRelative(0.0f, -28.5f, 103.1f, -51.6f, 230.2f, -51.6f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(401.1f, 112.9f)
                moveToRelative(-25.9f, 0.0f)
                arcToRelative(25.9f, 25.9f, 0.0f, true, true, 51.8f, 0.0f)
                arcToRelative(25.9f, 25.9f, 0.0f, true, true, -51.8f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(226.1f, 164.8f)
                moveToRelative(-23.0f, 0.0f)
                arcToRelative(23.0f, 23.0f, 0.0f, true, true, 46.0f, 0.0f)
                arcToRelative(23.0f, 23.0f, 0.0f, true, true, -46.0f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(114.9f, 273.8f)
                moveToRelative(-22.4f, 0.0f)
                arcToRelative(22.4f, 22.4f, 0.0f, true, true, 44.8f, 0.0f)
                arcToRelative(22.4f, 22.4f, 0.0f, true, true, -44.8f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(576.0f, 164.8f)
                moveToRelative(-23.0f, 0.0f)
                arcToRelative(23.0f, 23.0f, 0.0f, true, true, 46.0f, 0.0f)
                arcToRelative(23.0f, 23.0f, 0.0f, true, true, -46.0f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(688.4f, 273.8f)
                moveToRelative(-22.4f, 0.0f)
                arcToRelative(22.4f, 22.4f, 0.0f, true, true, 44.8f, 0.0f)
                arcToRelative(22.4f, 22.4f, 0.0f, true, true, -44.8f, 0.0f)
            }
        }
        .build()
        return _wq!!
    }

private var _wq: ImageVector? = null
