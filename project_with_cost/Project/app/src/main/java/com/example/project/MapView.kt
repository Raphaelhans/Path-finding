package com.example.project

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class MapView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    interface MapPoint {
        val id: String
        val x: Float
        val y: Float
    }

    data class Node(override val id: String, override val x: Float, override val y: Float, val label: String) : MapPoint
    data class Building(override val id: String, override val x: Float, override val y: Float, val address: String) : MapPoint

    val nodes = listOf(
        Node("1", 147f, 26f, "1: Jl. Pucang Anom Timur & Jl. Pucang Adi"),
        Node("2", 454f, 31f, "2: Jl. Pucang Adi & Jl. Alun-Alun Pucang Rinenggo"),
        Node("3", 750f, 31f, "3: Jl. Pucang Adi & Pucang Jajar"),
        Node("4", 142f, 101f, "4: Jl. Pucang Anom Timur & Pucang Rinenggo"),
        Node("5", 457f, 109f, "5: Jl. Alun-Alun Pucang Rinenggo & Jl. Pucang Rineggo"),
        Node("6", 142f, 207f, "6: Jl. Pucang Anom Timur & Pucang Anom"),
        Node("7", 454f, 197f, "7: Jl. Alun Alun Pucang Rineggo & Pucang Anom"),
        Node("8", 147f, 284f, "8: Jl. Pucang Anom Timur & Pucang Anom Timur II"),
        Node("9", 558f, 284f, "9: Jl. Pucang Anom Timur II & Jl. Pucang Anom Timur I"),
        Node("10", 139f, 371f, "10: Jl. Pucang Anom Timur  & Jl. Pucang Anom Timur III"),
        Node("11", 581f, 375f, "11: Jl. Pucang Anom Timur III & Jl. Pucang Anom Timur I"),
        Node("12", 562f, 209f, "12: Jl. Pucang Anom Timur I & Jl. Pucang Anom"),
        Node("13", 750f, 203f, "13: Jl. Pucang Anom  & Jl. Pucang Jajar"),
        Node("14", 151f, 573f, "14: Jl. Pucang Anom Timur  & Jl. Kalibokor"),
        Node("15", 139f, 404f, "15: Jl. Pucang Anom Timur & Jl. Pucang Anom Timur IV"),
        Node("16", 581f, 404f, "16: Jl. Pucang Anom Timur IV  & Jl. Pucang Anom Timur I"),
        Node("17", 572f, 597f, "17: Jl. Kalibokor  & Jl. Pucang Anom Timur I"),
        Node("18", 581f, 474f, "18: Jl. Pucang Anom Timur I  & Jl. Pucang Anom Timur V"),
        Node("19", 577f, 537f, "19: Jl. Pucang Anom Timur I  & Jl. Pucang Anom Timur VI"),
        Node("20", 227f, 573f, "20: Jl. Kalibokor  & Jl. Pucang Asri I"),
        Node("21", 231f, 399f, "21: Jl. Pucang Anom Timur IV  & Jl. Pucang Asri I"),
        Node("22", 292f, 401f, "22: Jl. Pucang Anom Timur IV  & Jl. Pucang Asri II"),
        Node("23", 297f, 576f, "23: Jl. Pucang Anom Timur VI  & Jl. Pucang Asri III"),
        Node("24", 393f, 467f, "24: Jl. Pucang Anom Timur V & Jl. Pucang Asri III"),
        Node("25", 300f, 467f, "25: Jl. Pucang Anom Timur V & Jl. Pucang Asri II"),
        Node("26", 304f, 522f, "26: Jl. Pucang Anom Timur VI  & Jl. Pucang Asri II"),
        Node("27", 396f, 537f, "27: Jl. Pucang Anom Timur VI  & Jl. Pucang Asri III"),
        Node("27A", 396f, 591f, "27A: Jl. Kalibokor  & Jl. Pucang Asri III"),
        Node("28", 758f, 612f, "28: Jl. Kalibokor  & Jl. Pucang Jajar & Jl. Kalibokor Timur"),
        Node("29", 758f, 667f, "29: Jl. Kalibokor Selatan & Jl. Pucang Jajar & Jl. Ngagel Madya"),
        Node("30", 746f, 922f, "30: Jl. Ngagel Jaya Utara & Jl. Ngagel Madya"),
        Node("31", 746f, 1289f, "31: Jl. Ngagel Jaya Tengah & Jl. Ngagel Madya"),
        Node("32", 415f, 1283f, "32: Jl. Ngagel Tama & Jl. Ngagel Madya Tengah"),
        Node("33", 415f, 907f, "33: Jl. Ngagel Tama & Jl. Ngagel Jaya Utara"),
        Node("34", 753f, 537f, "34: Jl. Pucang Jajar  & Jl. Pucang Anom Timur VI"),
        Node("35", 753f, 482f, "35: Jl. Pucang Jajar  & Jl. Pucang Anom Timur V"),
        Node("36", 220f, 628f, "36: Jl. Kalibokor Selatan  & Jl. Ngagel Tama Utara I"),
        Node("37", 227f, 691f, "37: Jl.  Ngagel Tama Utara II  & Jl. Ngagel Tama Utara I"),
        Node("38", 227f, 757f, "37: Jl.  Ngagel Tama Utara I  & Jl. Ngagel Tama Utara III"),
        Node("39", 227f, 822f, "39: Jl.  Ngagel Tama Utara I  & Jl. Ngagel Tama Utara IV"),
        Node("40", 231f, 886f, "40: Jl.  Ngagel Jaya Utara  & Jl. Ngagel Tama Utara I"),
        Node("41", 327f, 696f, "41: Jl.  Ngagel Tama Utara II  & Jl. Ngagel Tama Utara V"),
        Node("42", 327f, 759f, "42: Jl.  Ngagel Tama Utara III  & Jl. Ngagel Tama Utara V"),
        Node("43", 327f, 814f, "43: Jl.  Ngagel Tama Utara IV  & Jl. Ngagel Tama Utara V"),
        Node("44", 327f, 883f, "44: Jl.  Ngagel Jaya Utara  & Jl. Ngagel Tama Utara V"),
        Node("45", 243f, 994f, "45: Jl.  Ngagel Jaya Utara  & Jl. Ngagel Tama Tengah I"),
        Node("46", 239f, 994f, "46: Jl. Ngagel Tama Tengah II  & Jl. Ngagel Tama Tengah I"),
        Node("47", 311f, 997f, "47: Jl. Ngagel Tama Tengah II  & Jl. Ngagel Tama Tengah III"),
        Node("48", 304f, 1187f, "48: Jl. Ngagel Tama Tengah III  & Jl. Ngagel Tama Tengah IV"),
        Node("49", 227f, 1193f, "49: Jl. Ngagel Tama Tengah I  & Jl. Ngagel Tama Tengah IV"),
        Node("50", 220f, 1280f, "50: Jl. Ngagel Jaya Tengah  & Jl. Ngagel Tama Selatan I"),
        Node("51", 185f, 1352f, "51: Jl. Ngagel Tama Selatan I  & Jl. Ngagel Tama Selatan"),
        Node("52", 239f, 1358f, "52: Jl. Ngagel Tama Selatan III  & Jl. Ngagel Tama Selatan"),
        Node("53", 208f, 1481f, "53: Jl. Ngagel Tama Selatan II  & Jl. Ngagel Tama Selatan III"),
        Node("54", 154f, 1490f, "54: Jl. Ngagel Tama Selatan II  & Jl. Ngagel Tama Selatan I"),
        Node("55", 290f, 1358f, "55: Jl. Ngagel Tama Selatan  & Jl. Ngagel Tama Selatan IV"),
        Node("56", 258f, 1487f, "56: Jl. Ngagel Tama Selatan II & Jl. Ngagel Tama Selatan IV"),
        Node("57", 258f, 1487f, "57: Jl. Ngagel Tama Selatan II & Jl. Ngagel Tama Selatan IV"),
        Node("58", 304f, 1283f, "58: Jl. Ngagel Jaya Tengah & Jl. Ngagel Tama Selatan IV"),
        Node("59", 132f, 1563f, "59: Jl. Ngagel Jaya Selatan & Jl. Ngagel Tama Selatan I"),
        Node("60", 247f, 1557f, "60: Jl. Ngagel Jaya Selatan & Jl. Ngagel Tama Selatan IV"),
        Node("61", 427f, 1566f, "61: Jl. Ngagel Jaya Selatan & Jl. Ngagel Madya VIII"),
        Node("62", 443f, 1490f, "62: Jl. Ngagel Madya X & Jl. Ngagel Madya VIII"),
        Node("63", 450f, 1428f, "63: Jl. Ngagel Madya VII & Jl. Ngagel Madya VIII"),
        Node("64", 473f, 1361f, "64: Jl. Ngagel Madya VI & Jl. Ngagel Madya VIII"),
        Node("65", 669f, 1358f, "65: Jl. Ngagel Madya VI & Jl. Ngagel Madya V"),
        Node("66", 666f, 1430f, "66: Jl. Ngagel Madya VII & Jl. Ngagel Madya V"),
        Node("67", 673f, 1490f, "67: Jl. Ngagel Madya X & Jl. Ngagel Madya V"),
        Node("68", 396f, 1352f, "68: Jl. Ngagel Tama & Jl. Ngagel Madya VI"),
        Node("69", 346f, 1563f, "69: Jl. Ngagel Tama & Jl. Ngagel Jaya Selatan"),
        Node("70", 669f, 1566f, "70: Jl. Ngagel Madya V & Jl. Ngagel Jaya Selatan"),
        Node("71", 499f, 1280f, "71: Jl. Ngagel Madya I & Jl. Ngagel Jaya Tengah"),
        Node("72", 504f, 1139f, "72: Jl. Ngagel Madya I & Jl. Ngagel Madya III"),
        Node("73", 511f, 1060f, "73: Jl. Ngagel Madya I & Jl. Ngagel Madya II"),
        Node("74", 508f, 988f, "74: Jl. Ngagel Madya I & Jl. Ngagel Madya IA"),
        Node("75", 669f, 1003f, "75: Jl. Ngagel Madya V & Jl. Ngagel Madya IA"),
        Node("76", 669f, 1054f, "76: Jl. Ngagel Madya V & Jl. Ngagel Madya II"),
        Node("77", 669f, 1141f, "77: Jl. Ngagel Madya V & Jl. Ngagel Madya III"),
        Node("78", 669f, 1289f, "78: Jl. Ngagel Madya V & Jl. Ngagel Jaya Tengah"),
        Node("79", 142f, 624f, "79: Jl. Ngagel Jaya & Jl. Pucang Anom Timur & Jl. Kalibokor"),
        Node("80", 147f, 624f, "80: Jl. Ngagel Jaya & Jl. Pucang Anom Timur & Jl. Kalibokor Selatan"),
        Node("81", 154f, 883f, "81: Jl. Ngagel Jaya & Jl. Ngagel Jaya Utara"),
        Node("82", 128f, 1280f, "82: Jl. Ngagel Jaya Tengah & Jl. Ngagel Jaya"),
        Node("83", 48f, 1551f, "83: Jl. Ngagel Jaya Selatan & Jl. Ngagel Jaya"),
        Node("84", 826f, 1291f, "84: Jl. Ngagel Jaya Tengah & Jl. Ngagel Wasana I"),
        Node("85", 826f, 950f, "85: Jl. Ngagel Jaya Utara & Jl. Ngagel Wasana I"),
        Node("86", 1096f, 974f, "86: Jl. Ngagel Jaya Utara & Jl. Ngagel Wasana III"),
        Node("87", 1042f, 1292f, "87: Jl. Ngagel Jaya Tengah & Jl. Ngagel Wasana III"),
        Node("88", 1088f, 1028f, "88: Jl. Ngagel Wasana IV & Jl. Ngagel Wasana III"),
        Node("89", 1074f, 1072f, "89: Jl. Ngagel Wasana V & Jl. Ngagel Wasana III"),
        Node("90", 1042f, 1097f, "90: Jl. Ngagel Wasana Kalimir & Jl. Ngagel Wasana III"),
        Node("91", 1042f, 1140f, "91: Jl. Ngagel Wasana VI & Jl. Ngagel Wasana III"),
        Node("92", 1042f, 1176f, "92: Jl. Ngagel Wasana VIA & Jl. Ngagel Wasana III"),
        Node("93", 1042f, 1210f, "93: Jl. Ngagel Wasana VII & Jl. Ngagel Wasana III"),
        Node("94", 1042f, 1239f, "94: Jl. Ngagel Wasana VIIA & Jl. Ngagel Wasana III"),
        Node("95", 826f, 1028f, "95: Jl. Ngagel Wasana IV & Jl. Ngagel Wasana I"),
        Node("96", 826f, 1072f, "96: Jl. Ngagel Wasana V & Jl. Ngagel Wasana I"),
        Node("97", 826f, 1097f, "97: Jl. Ngagel Wasana Kalimir & Jl. Ngagel Wasana I"),
        Node("98", 826f, 1140f, "98: Jl. Ngagel Wasana VI & Jl. Ngagel Wasana I"),
        Node("99", 826f, 1176f, "99: Jl. Ngagel Wasana VIA & Jl. Ngagel Wasana I"),
        Node("100", 826f, 1210f, "100: Jl. Ngagel Wasana VII & Jl. Ngagel Wasana I"),
        Node("101", 826f, 1239f, "101: Jl. Ngagel Wasana VIIA & Jl. Ngagel Wasana I"),
        Node("102", 826f, 1357f, "102: Jl. Ngagel Wasana VIII & Jl. Ngagel Wasana I"),
        Node("103", 826f, 1421f, "103: Jl. Ngagel Wasana IX & Jl. Ngagel Wasana I"),
        Node("104", 826f, 1567f, "104: Jl. Ngagel Jaya Tengah & Jl. Ngagel Wasana I"),
        Node("105", 1040f, 1362f, "105: Jl. Ngagel Wasana VII & Jl. Ngagel Wasana III"),
        Node("106", 1029f, 1422f, "106: Jl. Ngagel Wasana IX & Jl. Ngagel Wasana III"),
        Node("107", 1014f, 1565f, "107: Jl. Ngagel Jaya Selatan IX & Jl. Ngagel Wasana III")
    )

    val buildings = listOf(
        Building("B1", 373f, 80f, "Gedung 1 - Jl. Pucang Rinenggo"),
        Building("B2", 373f, 240f, "Gedung 2 - Jl. Pucang Anom"),
        Building("B3", 224f, 80f, "Gedung 3 - Jl. Pucang Rinenggo"),
        Building("B4", 231f, 240f, "Gedung 4 - Jl. Pucang Anom"),
        Building("B5", 224f, 338f, "Gedung 5 - Jl. Pucang Anom Timur III"),
        Building("B6", 473f, 338f, "Gedung 6 - Jl. Pucang Anom Timur III"),
        Building("B7", 342f, 432f, "Gedung 7 - Jl. Pucang Asri IV"),
        Building("B8", 342f, 495f, "Gedung 8 - Jl. Pucang Asri V"),
        Building("B9", 342f, 558f, "Gedung 9 - Jl. Kalibokor"),
        Building("B10", 278f, 663f, "Gedung 10 - Jl. Ngagel Tama Utara II"),
        Building("B11", 278f, 733f, "Gedung 11 - Jl. Ngagel Tama Utara III"),
        Building("B12", 278f, 790f, "Gedung 12 - Jl. Ngagel Tama Utara IV"),
        Building("B13", 278f, 844f, "Gedung 13 - Jl. Ngagel Jaya Utara")
    )

    private var startBuilding: Building? = null
    private var endBuilding: Building? = null
    private var path: List<String> = emptyList()

    private val mapBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.map_image)
    private var scaleFactorX = 1f
    private var scaleFactorY = 1f

    private val nodePaint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.FILL
    }

    private val buildingPaint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.FILL
    }

    private val startPaint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.FILL
    }

    private val endPaint = Paint().apply {
        color = Color.RED
        style = Paint.Style.FILL
    }

    private val pathPaint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        scaleFactorX = w.toFloat() / mapBitmap.width
        scaleFactorY = h.toFloat() / mapBitmap.height
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(mapBitmap, 0f, 0f, null, scaleFactorX, scaleFactorY)

        if (path.isNotEmpty()) {
            val pathObj = Path()
            val firstId = path.first()
            val firstNode: MapPoint? = nodes.find { it.id == firstId } ?: buildings.find { it.id == firstId }
            if (firstNode != null) {
                pathObj.moveTo(firstNode.x * scaleFactorX, firstNode.y * scaleFactorY)
                for (i in 1 until path.size) {
                    val nextId = path[i]
                    val nextNode: MapPoint? = nodes.find { it.id == nextId } ?: buildings.find { it.id == nextId }
                    if (nextNode != null) {
                        pathObj.lineTo(nextNode.x * scaleFactorX, nextNode.y * scaleFactorY)
                    }
                }
                canvas.drawPath(pathObj, pathPaint)
            }
        }

        for (node in nodes) {
            canvas.drawCircle(node.x * scaleFactorX, node.y * scaleFactorY, 10f, nodePaint)
        }

        for (building in buildings) {
            val paint = when {
                building == startBuilding -> startPaint
                building == endBuilding -> endPaint
                else -> buildingPaint
            }
            canvas.drawCircle(building.x * scaleFactorX, building.y * scaleFactorY, 20f, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val x = event.x / scaleFactorX
            val y = event.y / scaleFactorY

            Log.d("MapView", "Tapped at: (x: $x, y: $y)")

            val closestBuilding = buildings.minByOrNull {
                val dx = (it.x - x)
                val dy = (it.y - y)
                dx * dx + dy * dy
            }

            if (closestBuilding != null) {
                val dx = (closestBuilding.x - x)
                val dy = (closestBuilding.y - y)
                val distance = dx * dx + dy * dy
                if (distance < 50 * 50) {
                    if (startBuilding == null) {
                        startBuilding = closestBuilding
                        Log.d("MapView", "Selected Start Building: ${closestBuilding.id}")
                    } else if (endBuilding == null && closestBuilding != startBuilding) {
                        endBuilding = closestBuilding
                        Log.d("MapView", "Selected End Building: ${closestBuilding.id}")
                    } else {
                        startBuilding = closestBuilding
                        endBuilding = null
                        path = emptyList()
                        Log.d("MapView", "Reset and Selected Start Building: ${closestBuilding.id}")
                    }
                    invalidate()
                    return true
                }
            }

            val closestNode = nodes.minByOrNull {
                val dx = (it.x - x)
                val dy = (it.y - y)
                dx * dx + dy * dy
            }

            if (closestNode != null) {
                val dx = (closestNode.x - x)
                val dy = (closestNode.y - y)
                val distance = dx * dx + dy * dy
                if (distance < 30 * 30) {
                    Log.d("MapView", "Node tapped: ${closestNode.id} at (x: ${closestNode.x}, y: ${closestNode.y})")
                    return true
                }
            }
        }
        return true
    }

    fun getStartBuildingId(): String? = startBuilding?.id
    fun getEndBuildingId(): String? = endBuilding?.id
    fun setPath(newPath: List<String>) {
        path = newPath
        invalidate()
    }

    fun resetSelection() {
        startBuilding = null
        endBuilding = null
        path = emptyList()
        invalidate()
    }

    fun getNodeById(id: String): Node? = nodes.find { it.id == id }
    fun getBuildingById(id: String): Building? = buildings.find { it.id == id }

    fun estimateDistance(pointId: String, endId: String): Float {
        val point: MapPoint? = nodes.find { it.id == pointId } ?: buildings.find { it.id == pointId }
        val end: MapPoint? = nodes.find { it.id == endId } ?: buildings.find { it.id == endId }
        if (point == null || end == null) {
            return kotlin.math.abs(pointId.replace("B", "").toIntOrNull() ?: 0 - (endId.replace("B", "").toIntOrNull() ?: 0)).toFloat()
        }
        val dx = point.x - end.x
        val dy = point.y - end.y
        return kotlin.math.sqrt((dx * dx + dy * dy).toDouble()).toFloat()
    }

    fun lineIntersectBuilding(x1: Float, y1: Float, x2: Float, y2: Float): Boolean {
        for (building in buildings) {
            val radius = 20f
            val dx = x2 - x1
            val dy = y2 - y1
            val t = ((building.x - x1) * dx + (building.y - y1) * dy) / (dx * dx + dy * dy)
            val closestT = t.coerceIn(0f, 1f)
            val closestX = x1 + closestT * dx
            val closestY = y1 + closestT * dy
            val distX = building.x - closestX
            val distY = building.y - closestY
            val distance = kotlin.math.sqrt((distX * distX + distY * distY).toDouble())
            if (distance < radius) {
                return true
            }
        }
        return false
    }
}

fun Canvas.drawBitmap(bitmap: Bitmap, left: Float, top: Float, paint: Paint?, scaleX: Float, scaleY: Float) {
    val matrix = android.graphics.Matrix().apply {
        postScale(scaleX, scaleY)
        postTranslate(left, top)
    }
    drawBitmap(bitmap, matrix, paint)
}