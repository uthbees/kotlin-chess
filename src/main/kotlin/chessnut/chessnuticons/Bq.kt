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

public val ChessnutIcons.Bq: ImageVector
    get() {
        if (_bq != null) {
            return _bq!!
        }
        _bq = Builder(name = "Bq", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp, viewportWidth
                = 800.0f, viewportHeight = 800.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(400.0f, 704.4f)
                curveToRelative(-62.0f, 0.0f, -120.5f, -5.5f, -164.8f, -15.4f)
                curveToRelative(-49.7f, -11.1f, -74.2f, -25.8f, -75.0f, -44.8f)
                lineTo(150.0f, 587.0f)
                verticalLineToRelative(-0.9f)
                curveToRelative(0.0f, -5.4f, 1.6f, -13.2f, 8.6f, -21.4f)
                curveToRelative(-7.5f, -43.1f, -24.6f, -117.2f, -44.6f, -192.2f)
                curveToRelative(-18.4f, -6.9f, -30.8f, -24.5f, -30.8f, -44.6f)
                curveToRelative(0.0f, -26.4f, 21.4f, -47.7f, 47.7f, -47.7f)
                reflectiveCurveToRelative(47.7f, 21.4f, 47.7f, 47.7f)
                curveToRelative(0.0f, 11.1f, -3.7f, 21.5f, -10.6f, 29.9f)
                curveToRelative(21.1f, 67.1f, 46.9f, 136.7f, 64.9f, 175.2f)
                lineToRelative(5.3f, -1.3f)
                curveToRelative(-0.5f, -55.3f, -9.1f, -164.3f, -20.6f, -261.6f)
                curveToRelative(-18.6f, -8.0f, -31.0f, -26.6f, -31.0f, -47.1f)
                curveToRelative(0.0f, -28.3f, 23.0f, -51.3f, 51.3f, -51.3f)
                reflectiveCurveToRelative(51.3f, 23.0f, 51.3f, 51.3f)
                curveToRelative(0.0f, 13.8f, -5.4f, 26.7f, -15.0f, 36.3f)
                curveToRelative(17.9f, 93.5f, 47.7f, 211.6f, 65.3f, 258.9f)
                lineToRelative(5.4f, -0.3f)
                curveToRelative(8.6f, -66.0f, 19.4f, -184.5f, 24.6f, -294.5f)
                curveToRelative(-14.9f, -9.9f, -23.8f, -26.5f, -23.8f, -44.5f)
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
                curveToRelative(-19.9f, 75.1f, -37.0f, 149.1f, -44.6f, 192.2f)
                curveToRelative(5.7f, 6.7f, 8.6f, 13.8f, 8.6f, 21.3f)
                verticalLineToRelative(0.9f)
                lineToRelative(-10.3f, 57.7f)
                curveToRelative(-1.2f, 18.9f, -25.7f, 33.5f, -75.0f, 44.6f)
                curveToRelative(-43.8f, 9.6f, -102.3f, 15.1f, -164.4f, 15.1f)
                close()
                moveTo(215.0f, 632.7f)
                curveToRelative(10.8f, 7.2f, 34.9f, 14.3f, 66.2f, 19.1f)
                curveToRelative(34.3f, 5.4f, 75.4f, 8.2f, 118.8f, 8.2f)
                curveToRelative(98.0f, 0.0f, 163.9f, -13.8f, 184.2f, -26.9f)
                lineToRelative(3.3f, -2.9f)
                curveToRelative(-4.2f, -4.2f, -17.0f, -11.4f, -48.7f, -17.7f)
                curveToRelative(-35.3f, -6.9f, -84.7f, -10.7f, -138.9f, -10.7f)
                curveToRelative(-50.3f, 0.0f, -98.2f, 3.9f, -134.6f, 11.0f)
                curveToRelative(-33.2f, 6.5f, -47.5f, 13.8f, -52.6f, 17.9f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(400.0f, 134.5f)
                curveToRelative(24.4f, 0.0f, 44.3f, 19.9f, 44.3f, 44.3f)
                curveToRelative(0.0f, 17.1f, -9.6f, 31.9f, -23.8f, 39.2f)
                curveToRelative(5.1f, 114.0f, 16.8f, 242.6f, 26.0f, 309.1f)
                lineToRelative(20.4f, 1.3f)
                curveToRelative(18.1f, -44.7f, 51.4f, -176.8f, 69.4f, -272.6f)
                curveToRelative(-9.7f, -7.6f, -15.9f, -19.4f, -15.9f, -32.7f)
                curveToRelative(0.0f, -23.0f, 18.6f, -41.6f, 41.6f, -41.6f)
                reflectiveCurveToRelative(41.6f, 18.6f, 41.6f, 41.6f)
                curveToRelative(0.0f, 19.0f, -12.7f, 35.0f, -30.2f, 40.0f)
                curveToRelative(-12.3f, 102.1f, -21.8f, 222.0f, -21.5f, 276.4f)
                lineToRelative(20.4f, 4.9f)
                curveToRelative(20.3f, -41.1f, 49.7f, -121.9f, 70.4f, -188.9f)
                curveToRelative(-7.2f, -6.9f, -11.8f, -16.6f, -11.8f, -27.5f)
                curveToRelative(0.0f, -21.0f, 17.0f, -38.0f, 38.0f, -38.0f)
                reflectiveCurveToRelative(38.0f, 17.0f, 38.0f, 38.0f)
                curveToRelative(0.0f, 17.9f, -12.4f, 32.9f, -29.1f, 36.9f)
                curveToRelative(-20.8f, 78.0f, -39.5f, 158.2f, -47.0f, 203.1f)
                curveToRelative(6.0f, 5.7f, 9.4f, 11.8f, 9.4f, 18.1f)
                lineToRelative(-10.2f, 57.0f)
                lineToRelative(-0.1f, 0.1f)
                curveToRelative(0.0f, 28.5f, -103.0f, 51.6f, -230.0f, 51.6f)
                curveToRelative(-127.1f, 0.0f, -230.0f, -23.4f, -230.0f, -51.5f)
                lineToRelative(-10.2f, -57.1f)
                curveToRelative(0.0f, -6.3f, 3.2f, -12.5f, 9.4f, -18.3f)
                curveToRelative(-7.5f, -44.9f, -26.1f, -125.2f, -47.0f, -203.1f)
                curveToRelative(-16.6f, -4.0f, -29.1f, -19.0f, -29.1f, -36.9f)
                curveToRelative(0.0f, -21.0f, 17.0f, -38.0f, 38.0f, -38.0f)
                curveToRelative(21.1f, 0.0f, 38.0f, 17.0f, 38.0f, 38.0f)
                curveToRelative(0.0f, 10.8f, -4.5f, 20.6f, -11.8f, 27.5f)
                curveToRelative(20.8f, 67.0f, 50.1f, 147.9f, 70.4f, 188.9f)
                lineToRelative(20.4f, -4.9f)
                curveToRelative(0.3f, -54.2f, -9.2f, -174.3f, -21.5f, -276.4f)
                curveToRelative(-17.4f, -5.0f, -30.2f, -21.0f, -30.2f, -40.0f)
                curveToRelative(0.0f, -23.0f, 18.6f, -41.6f, 41.6f, -41.6f)
                reflectiveCurveToRelative(41.6f, 18.6f, 41.6f, 41.6f)
                curveToRelative(0.0f, 13.3f, -6.3f, 25.1f, -15.9f, 32.7f)
                curveToRelative(18.0f, 95.8f, 51.2f, 227.9f, 69.4f, 272.6f)
                lineToRelative(20.4f, -1.3f)
                curveToRelative(9.1f, -66.5f, 20.8f, -195.0f, 26.0f, -309.1f)
                curveToRelative(-14.1f, -7.5f, -23.8f, -22.1f, -23.8f, -39.2f)
                curveToRelative(0.1f, -24.3f, 20.0f, -44.2f, 44.4f, -44.2f)
                moveToRelative(0.0f, 535.3f)
                curveToRelative(89.4f, 0.0f, 165.0f, -12.1f, 190.2f, -28.8f)
                lineToRelative(9.0f, -7.9f)
                curveToRelative(0.0f, -25.6f, -89.1f, -41.0f, -199.0f, -41.0f)
                reflectiveCurveToRelative(-199.0f, 18.4f, -199.0f, 41.0f)
                lineToRelative(8.1f, 7.2f)
                curveToRelative(24.0f, 17.0f, 100.3f, 29.5f, 190.7f, 29.5f)
                moveToRelative(0.0f, -554.7f)
                curveToRelative(-35.1f, 0.0f, -63.7f, 28.6f, -63.7f, 63.7f)
                curveToRelative(0.0f, 19.3f, 8.6f, 37.3f, 23.2f, 49.2f)
                curveToRelative(-4.4f, 92.8f, -12.9f, 190.8f, -20.5f, 257.8f)
                curveToRelative(-17.0f, -55.4f, -39.6f, -148.1f, -54.3f, -223.5f)
                curveToRelative(9.2f, -10.9f, 14.4f, -24.7f, 14.4f, -39.3f)
                curveToRelative(0.0f, -33.7f, -27.3f, -61.0f, -61.0f, -61.0f)
                reflectiveCurveToRelative(-61.0f, 27.3f, -61.0f, 61.0f)
                curveToRelative(0.0f, 13.5f, 4.3f, 26.4f, 12.6f, 37.2f)
                curveToRelative(5.2f, 6.7f, 11.7f, 12.3f, 19.1f, 16.4f)
                curveToRelative(9.1f, 77.4f, 16.2f, 161.5f, 18.9f, 219.2f)
                curveToRelative(-15.3f, -37.6f, -33.2f, -87.4f, -48.6f, -136.3f)
                curveToRelative(6.2f, -9.3f, 9.6f, -20.4f, 9.6f, -31.6f)
                curveToRelative(0.0f, -31.6f, -25.8f, -57.5f, -57.5f, -57.5f)
                curveToRelative(-31.6f, 0.0f, -57.6f, 25.7f, -57.6f, 57.3f)
                curveToRelative(0.0f, 22.5f, 12.9f, 42.2f, 32.3f, 51.6f)
                curveToRelative(18.7f, 70.8f, 34.8f, 140.2f, 42.4f, 182.6f)
                curveToRelative(-6.5f, 9.1f, -8.1f, 17.7f, -8.1f, 24.0f)
                verticalLineToRelative(1.7f)
                lineToRelative(0.3f, 1.7f)
                lineToRelative(9.9f, 55.8f)
                curveToRelative(0.4f, 5.7f, 2.6f, 13.5f, 9.7f, 21.4f)
                curveToRelative(4.6f, 5.0f, 10.7f, 9.4f, 18.7f, 13.6f)
                curveToRelative(13.1f, 6.9f, 31.3f, 13.1f, 54.1f, 18.1f)
                curveToRelative(45.0f, 10.2f, 104.3f, 15.7f, 167.0f, 15.7f)
                curveToRelative(62.9f, 0.0f, 122.1f, -5.5f, 167.0f, -15.7f)
                curveToRelative(22.8f, -5.1f, 41.0f, -11.2f, 54.1f, -18.3f)
                curveToRelative(8.0f, -4.2f, 14.0f, -8.7f, 18.7f, -13.7f)
                curveToRelative(4.1f, -4.5f, 6.6f, -9.1f, 8.0f, -13.2f)
                lineToRelative(0.3f, -0.3f)
                lineToRelative(0.3f, -1.8f)
                curveToRelative(0.5f, -1.9f, 0.9f, -3.8f, 1.0f, -5.5f)
                lineToRelative(10.0f, -56.4f)
                lineToRelative(0.3f, -1.7f)
                verticalLineTo(586.0f)
                curveToRelative(0.0f, -6.2f, -1.6f, -14.8f, -8.1f, -23.9f)
                curveToRelative(7.6f, -42.4f, 23.8f, -111.8f, 42.4f, -182.6f)
                curveToRelative(19.4f, -9.4f, 32.3f, -29.3f, 32.3f, -51.6f)
                curveToRelative(0.0f, -31.6f, -25.8f, -57.5f, -57.5f, -57.5f)
                curveToRelative(-31.6f, 0.0f, -57.5f, 25.8f, -57.5f, 57.5f)
                curveToRelative(0.0f, 11.3f, 3.3f, 22.4f, 9.6f, 31.6f)
                curveToRelative(-15.4f, 48.9f, -33.4f, 98.7f, -48.6f, 136.3f)
                curveToRelative(2.7f, -57.8f, 9.8f, -141.8f, 18.9f, -219.2f)
                curveToRelative(7.3f, -4.1f, 13.9f, -9.6f, 19.1f, -16.4f)
                curveToRelative(8.2f, -10.7f, 12.6f, -23.5f, 12.6f, -37.2f)
                curveToRelative(0.0f, -33.7f, -27.3f, -61.0f, -61.0f, -61.0f)
                reflectiveCurveToRelative(-61.0f, 27.3f, -61.0f, 61.0f)
                curveToRelative(0.0f, 14.6f, 5.1f, 28.4f, 14.4f, 39.3f)
                curveToRelative(-14.7f, 75.4f, -37.4f, 168.0f, -54.3f, 223.5f)
                curveToRelative(-7.7f, -67.0f, -16.1f, -164.9f, -20.5f, -257.8f)
                curveToRelative(14.5f, -11.9f, 23.1f, -29.8f, 23.1f, -49.1f)
                curveToRelative(0.2f, -35.2f, -28.4f, -63.8f, -63.5f, -63.8f)
                close()
                moveTo(234.0f, 631.0f)
                curveToRelative(8.5f, -3.0f, 21.6f, -6.7f, 41.3f, -10.0f)
                curveToRelative(34.7f, -6.0f, 78.9f, -9.3f, 124.7f, -9.3f)
                curveToRelative(48.0f, 0.0f, 91.2f, 2.9f, 125.1f, 8.4f)
                curveToRelative(21.1f, 3.5f, 34.3f, 7.1f, 42.7f, 10.4f)
                curveToRelative(-9.5f, 3.6f, -25.5f, 8.1f, -51.5f, 12.1f)
                curveToRelative(-33.7f, 5.2f, -73.9f, 7.9f, -116.2f, 7.9f)
                curveToRelative(-42.9f, 0.0f, -83.4f, -2.8f, -117.3f, -8.1f)
                curveToRelative(-24.0f, -3.8f, -39.2f, -8.1f, -48.8f, -11.4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(400.0f, 112.9f)
                moveToRelative(-25.9f, 0.0f)
                arcToRelative(25.9f, 25.9f, 0.0f, true, true, 51.8f, 0.0f)
                arcToRelative(25.9f, 25.9f, 0.0f, true, true, -51.8f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(225.0f, 164.8f)
                moveToRelative(-23.0f, 0.0f)
                arcToRelative(23.0f, 23.0f, 0.0f, true, true, 46.0f, 0.0f)
                arcToRelative(23.0f, 23.0f, 0.0f, true, true, -46.0f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(113.8f, 273.8f)
                moveToRelative(-22.4f, 0.0f)
                arcToRelative(22.4f, 22.4f, 0.0f, true, true, 44.8f, 0.0f)
                arcToRelative(22.4f, 22.4f, 0.0f, true, true, -44.8f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(575.0f, 164.8f)
                moveToRelative(-23.0f, 0.0f)
                arcToRelative(23.0f, 23.0f, 0.0f, true, true, 46.0f, 0.0f)
                arcToRelative(23.0f, 23.0f, 0.0f, true, true, -46.0f, 0.0f)
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(687.3f, 273.8f)
                moveToRelative(-22.4f, 0.0f)
                arcToRelative(22.4f, 22.4f, 0.0f, true, true, 44.8f, 0.0f)
                arcToRelative(22.4f, 22.4f, 0.0f, true, true, -44.8f, 0.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFf2f2f2)),
                    strokeLineWidth = 17.28f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(117.6f, 287.9f)
                lineToRelative(-4.5f, -15.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFf2f2f2)),
                    strokeLineWidth = 18.36f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(228.8f, 180.7f)
                lineToRelative(-4.4f, -18.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFf2f2f2)),
                    strokeLineWidth = 17.28f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(682.7f, 287.9f)
                lineToRelative(4.6f, -15.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFf2f2f2)),
                    strokeLineWidth = 18.36f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(570.4f, 180.7f)
                lineToRelative(4.6f, -18.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFf2f2f2)),
                    strokeLineWidth = 20.52f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(399.5f, 108.6f)
                verticalLineTo(127.0f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFf2f2f2)),
                    strokeLineWidth = 15.12f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(263.7f, 255.8f)
                curveToRelative(9.7f, -7.6f, 15.9f, -19.4f, 15.9f, -32.7f)
                curveToRelative(0.0f, -23.0f, -18.6f, -41.6f, -41.6f, -41.6f)
                reflectiveCurveToRelative(-41.6f, 18.6f, -41.6f, 41.6f)
                curveToRelative(0.0f, 19.0f, 12.7f, 35.0f, 30.2f, 40.0f)
                curveToRelative(12.3f, 102.1f, 21.8f, 215.6f, 21.5f, 269.9f)
                lineToRelative(-20.4f, 4.9f)
                moveTo(420.5f, 218.0f)
                curveToRelative(14.1f, -7.5f, 23.8f, -22.1f, 23.8f, -39.2f)
                curveToRelative(0.0f, -24.4f, -19.9f, -44.3f, -44.3f, -44.3f)
                reflectiveCurveToRelative(-44.3f, 19.9f, -44.3f, 44.3f)
                curveToRelative(0.0f, 17.1f, 9.6f, 31.9f, 23.8f, 39.2f)
                curveToRelative(-5.1f, 114.0f, -16.8f, 236.1f, -26.0f, 302.6f)
                lineToRelative(-20.4f, 1.3f)
                moveTo(573.3f, 263.0f)
                curveToRelative(17.4f, -5.0f, 30.2f, -21.0f, 30.2f, -40.0f)
                curveToRelative(0.0f, -23.0f, -18.6f, -41.6f, -41.6f, -41.6f)
                reflectiveCurveTo(520.3f, 200.0f, 520.3f, 223.0f)
                curveToRelative(0.0f, 13.3f, 6.3f, 25.1f, 15.9f, 32.7f)
                curveToRelative(-18.0f, 95.8f, -51.2f, 221.4f, -69.4f, 266.1f)
                lineToRelative(-20.4f, -1.3f)
                moveToRelative(231.5f, -155.7f)
                curveToRelative(16.6f, -4.0f, 29.1f, -19.0f, 29.1f, -36.9f)
                curveToRelative(0.0f, -21.0f, -17.0f, -38.0f, -38.0f, -38.0f)
                reflectiveCurveToRelative(-38.0f, 17.0f, -38.0f, 38.0f)
                curveToRelative(0.0f, 10.8f, 4.5f, 20.6f, 11.8f, 27.5f)
                curveToRelative(-20.8f, 67.0f, -50.1f, 141.4f, -70.4f, 182.4f)
                lineToRelative(-20.4f, -4.9f)
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFf2f2f2)),
                    strokeLineWidth = 15.12f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(157.2f, 355.4f)
                curveToRelative(7.2f, -6.9f, 11.8f, -16.6f, 11.8f, -27.5f)
                curveToRelative(0.0f, -21.0f, -17.0f, -38.0f, -38.0f, -38.0f)
                curveToRelative(-21.1f, 0.0f, -38.0f, 17.0f, -38.0f, 38.0f)
                curveToRelative(0.0f, 17.9f, 12.4f, 32.9f, 29.1f, 36.9f)
                curveToRelative(20.8f, 78.0f, 39.5f, 155.0f, 47.0f, 199.9f)
                curveToRelative(-6.0f, 5.7f, -9.4f, 11.8f, -9.4f, 18.1f)
                lineToRelative(10.2f, 60.3f)
                curveToRelative(0.0f, -28.5f, 103.0f, -51.6f, 230.1f, -51.6f)
                reflectiveCurveToRelative(230.1f, 23.1f, 230.1f, 51.6f)
                lineToRelative(10.2f, -60.3f)
                curveToRelative(0.0f, -6.3f, -3.2f, -12.3f, -9.4f, -18.1f)
            }
        }
        .build()
        return _bq!!
    }

private var _bq: ImageVector? = null
