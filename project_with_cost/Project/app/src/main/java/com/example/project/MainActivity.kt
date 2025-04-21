package com.example.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var graph: Map<String, List<Pair<String, Float>>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        graph = mapOf(
            "1" to listOf("2" to 30f, "4" to 25f),
            "2" to listOf("1" to 30f, "3" to 35f, "5" to 28f),
            "3" to listOf("2" to 35f, "13" to 40f),
            "4" to listOf("1" to 25f, "6" to 32f, "B3" to 15f),
            "5" to listOf("2" to 28f, "7" to 30f, "B1" to 20f),
            "6" to listOf("4" to 32f, "8" to 35f, "B4" to 18f),
            "7" to listOf("5" to 30f, "9" to 33f, "12" to 25f, "B2" to 22f),
            "8" to listOf("6" to 35f, "9" to 40f, "10" to 38f, "15" to 30f),
            "9" to listOf("8" to 40f, "11" to 35f, "12" to 28f),
            "10" to listOf("15" to 25f, "14" to 45f, "11" to 32f, "B5" to 20f),
            "11" to listOf("9" to 35f, "10" to 32f, "16" to 28f),
            "12" to listOf("7" to 25f, "9" to 28f, "13" to 35f),
            "13" to listOf("3" to 40f, "12" to 35f, "34" to 30f),
            "14" to listOf("10" to 45f, "20" to 33f, "79" to 28f),
            "15" to listOf("8" to 30f, "10" to 25f, "21" to 35f),
            "16" to listOf("11" to 28f, "18" to 30f),
            "17" to listOf("19" to 25f, "28" to 40f, "27A" to 32f),
            "18" to listOf("16" to 30f, "19" to 28f, "24" to 35f, "35" to 33f),
            "19" to listOf("17" to 25f, "18" to 28f, "27" to 30f),
            "20" to listOf("14" to 33f, "21" to 35f, "23" to 28f),
            "21" to listOf("15" to 35f, "20" to 35f, "22" to 25f),
            "22" to listOf("21" to 25f, "25" to 30f),
            "23" to listOf("20" to 28f, "26" to 32f, "27A" to 35f),
            "24" to listOf("18" to 35f, "25" to 28f, "27" to 33f),
            "25" to listOf("22" to 30f, "24" to 28f, "26" to 25f),
            "26" to listOf("23" to 32f, "25" to 25f, "27" to 28f),
            "27" to listOf("26" to 28f, "24" to 33f, "19" to 30f, "27A" to 25f),
            "27A" to listOf("27" to 25f, "17" to 32f, "23" to 35f, "28" to 38f),
            "28" to listOf("17" to 40f, "29" to 35f, "34" to 30f, "27A" to 38f),
            "29" to listOf("28" to 35f, "30" to 40f),
            "30" to listOf("29" to 40f, "31" to 45f, "33" to 35f),
            "31" to listOf("30" to 45f, "32" to 40f, "78" to 38f, "82" to 35f),
            "32" to listOf("31" to 40f, "33" to 38f, "68" to 35f),
            "33" to listOf("30" to 35f, "32" to 38f, "40" to 40f, "44" to 35f),
            "34" to listOf("13" to 30f, "28" to 30f, "35" to 25f),
            "35" to listOf("18" to 33f, "34" to 25f),
            "36" to listOf("37" to 30f, "80" to 28f),
            "37" to listOf("36" to 30f, "38" to 35f, "41" to 25f),
            "38" to listOf("37" to 35f, "39" to 30f, "42" to 28f),
            "39" to listOf("38" to 30f, "40" to 35f, "43" to 25f),
            "40" to listOf("39" to 35f, "44" to 30f, "81" to 28f),
            "41" to listOf("37" to 25f, "42" to 30f),
            "42" to listOf("38" to 28f, "41" to 30f, "43" to 35f),
            "43" to listOf("39" to 25f, "42" to 35f, "44" to 30f),
            "44" to listOf("40" to 30f, "43" to 30f, "33" to 35f),
            "45" to listOf("44" to 35f, "46" to 25f),
            "46" to listOf("45" to 25f, "47" to 30f, "49" to 35f),
            "47" to listOf("46" to 30f, "48" to 40f),
            "48" to listOf("47" to 40f, "49" to 35f, "58" to 30f),
            "49" to listOf("46" to 35f, "48" to 35f, "50" to 28f),
            "50" to listOf("49" to 28f, "51" to 35f, "58" to 30f, "B5" to 25f),
            "51" to listOf("50" to 35f, "52" to 30f, "54" to 28f),
            "52" to listOf("51" to 30f, "53" to 35f, "55" to 25f),
            "53" to listOf("52" to 35f, "56" to 30f),
            "54" to listOf("51" to 28f, "56" to 35f, "59" to 40f),
            "55" to listOf("52" to 25f, "58" to 30f, "60" to 35f),
            "56" to listOf("53" to 30f, "54" to 35f, "60" to 28f),
            "58" to listOf("48" to 30f, "50" to 30f, "55" to 30f, "60" to 35f),
            "59" to listOf("54" to 40f, "60" to 30f, "83" to 35f),
            "60" to listOf("55" to 35f, "56" to 28f, "58" to 35f, "59" to 30f, "61" to 40f),
            "61" to listOf("60" to 40f, "62" to 35f, "69" to 30f),
            "62" to listOf("61" to 35f, "63" to 30f, "67" to 28f),
            "63" to listOf("62" to 30f, "64" to 35f, "66" to 25f),
            "64" to listOf("63" to 35f, "65" to 30f, "68" to 28f),
            "65" to listOf("64" to 30f, "66" to 25f, "70" to 35f, "78" to 40f),
            "66" to listOf("63" to 25f, "65" to 25f, "67" to 30f),
            "67" to listOf("62" to 28f, "66" to 30f, "70" to 35f),
            "68" to listOf("32" to 35f, "64" to 28f, "71" to 30f),
            "69" to listOf("61" to 30f, "70" to 35f),
            "70" to listOf("65" to 35f, "67" to 35f, "69" to 35f),
            "71" to listOf("68" to 30f, "72" to 35f, "78" to 40f),
            "72" to listOf("71" to 35f, "73" to 30f, "77" to 28f),
            "73" to listOf("72" to 30f, "74" to 25f, "76" to 35f),
            "74" to listOf("73" to 25f, "75" to 30f),
            "75" to listOf("74" to 30f, "76" to 35f),
            "76" to listOf("73" to 35f, "75" to 35f, "77" to 30f),
            "77" to listOf("72" to 28f, "76" to 30f, "78" to 35f),
            "78" to listOf("31" to 38f, "65" to 40f, "71" to 40f, "77" to 35f, "84" to 30f),
            "79" to listOf("14" to 28f, "80" to 25f),
            "80" to listOf("36" to 28f, "79" to 25f),
            "81" to listOf("40" to 28f, "44" to 30f),
            "82" to listOf("31" to 35f, "50" to 28f),
            "83" to listOf("59" to 35f, "104" to 40f),
            "84" to listOf("78" to 30f, "87" to 35f),
            "85" to listOf("30" to 35f, "86" to 40f, "95" to 30f),
            "86" to listOf("85" to 40f, "88" to 35f),
            "87" to listOf("84" to 35f, "105" to 30f),
            "88" to listOf("86" to 35f, "89" to 28f),
            "89" to listOf("88" to 28f, "90" to 30f),
            "90" to listOf("89" to 30f, "91" to 25f),
            "91" to listOf("90" to 25f, "92" to 30f),
            "92" to listOf("91" to 30f, "93" to 35f),
            "93" to listOf("92" to 35f, "94" to 28f),
            "94" to listOf("93" to 28f, "105" to 30f),
            "95" to listOf("85" to 30f, "96" to 35f),
            "96" to listOf("95" to 35f, "97" to 28f),
            "97" to listOf("96" to 28f, "98" to 30f),
            "98" to listOf("97" to 30f, "99" to 25f),
            "99" to listOf("98" to 25f, "100" to 30f),
            "100" to listOf("99" to 30f, "101" to 35f),
            "101" to listOf("100" to 35f, "102" to 28f),
            "102" to listOf("101" to 28f, "103" to 30f),
            "103" to listOf("102" to 30f, "104" to 35f),
            "104" to listOf("83" to 40f, "103" to 35f, "107" to 30f),
            "105" to listOf("87" to 30f, "94" to 30f, "106" to 35f),
            "106" to listOf("105" to 35f, "107" to 28f),
            "107" to listOf("104" to 30f, "106" to 28f),
            "108" to listOf("82" to 30f, "83" to 35f),
            "109" to listOf("30" to 35f, "85" to 40f),
            "110" to listOf("109" to 40f, "31" to 35f),
            "B1" to listOf("4" to 15f, "5" to 20f),
            "B2" to listOf("7" to 22f, "6" to 18f),
            "B3" to listOf("4" to 15f, "5" to 20f),
            "B4" to listOf("6" to 18f, "7" to 22f),
            "B5" to listOf("10" to 20f, "11" to 25f),
            "B6" to listOf("10" to 20f, "11" to 25f),
            "B7" to listOf("25" to 25f, "24" to 28f),
            "B8" to listOf("26" to 25f, "27" to 28f),
            "B9" to listOf("23" to 30f, "27A" to 35f),
            "B10" to listOf("41" to 25f, "37" to 30f),
            "B11" to listOf("38" to 28f, "42" to 30f),
            "B12" to listOf("39" to 25f, "43" to 30f),
            "B13" to listOf("40" to 28f, "44" to 30f),
            "B14" to listOf("30" to 25f),
            "B15" to listOf("109" to 30f, "110" to 40f),
            "B16" to listOf("82" to 35f, "49" to 28f),
            "B17" to listOf("51" to 25f, "82" to 30f, "108" to 35f),
            "B18" to listOf("59" to 35f, "60" to 28f, "69" to 39f),
            "B19" to listOf("61" to 40f, "70" to 25f),
            "B20" to listOf("104" to 30f, "107" to 28f),
        )

        val newGraph = mutableMapOf<String, MutableList<Pair<String, Float>>>()

        for (nodeId in graph.keys) {
            newGraph[nodeId] = mutableListOf()
        }

        for ((nodeId, neighbors) in graph) {
            for (neighborPair in neighbors) {
                val neighborId = neighborPair.first
                var cost = neighborPair.second

                if (nodeId.startsWith("B") || neighborId.startsWith("B")) {
                    cost = (cost * 0.67f).coerceAtLeast(5f)
                }

                if (newGraph[nodeId]?.none { it.first == neighborId } == true) {
                    newGraph[nodeId]?.add(Pair(neighborId, cost))
                }

                if (newGraph[neighborId] == null) {
                    newGraph[neighborId] = mutableListOf()
                }

                if (newGraph[neighborId]?.none { it.first == nodeId } == true) {
                    newGraph[neighborId]?.add(Pair(nodeId, cost))
                }
            }
        }
        graph = newGraph

        binding.findPathButton.setOnClickListener {
            val startBuilding = binding.mapView.getStartBuildingId()
            val endBuilding = binding.mapView.getEndBuildingId()

            if (startBuilding != null && endBuilding != null) {
                val (path, totalCost, errorMessage) = findPathWithAStar(startBuilding, endBuilding)
                binding.mapView.setPath(path)
                displayPath(path, totalCost, startBuilding, endBuilding, errorMessage)
            } else {
                binding.pathTextView.text = "Please select both start and end buildings."
            }
        }

        binding.resetButton.setOnClickListener {
            binding.mapView.resetSelection()
            binding.pathTextView.text = "Path will be displayed here"
        }
    }

    private data class Node(
        val id: String,
        val g: Float,
        val h: Float,
        val parent: Node?,
        val previousNodeId: String?
    ) : Comparable<Node> {
        val f: Float = g + h
        override fun compareTo(other: Node): Int = f.compareTo(other.f)
    }

    private fun findPathWithAStar(startId: String, endId: String): Triple<List<String>, Float, String?> {
        if (startId !in graph) {
            return Triple(emptyList(), 0f, "Start node $startId not found in the graph")
        }
        if (endId !in graph) {
            return Triple(emptyList(), 0f, "End node $endId not found in the graph")
        }

        if (startId == endId) {
            return Triple(listOf(startId), 0f, null)
        }

        val openList = PriorityQueue<Node>()
        val closedList = mutableSetOf<String>()
        val parentMap = mutableMapOf<String, Node>()

        val startNode = Node(startId, 0f, binding.mapView.estimateDistance(startId, endId).toFloat(), null, null)
        openList.add(startNode)
        parentMap[startId] = startNode

        while (openList.isNotEmpty()) {
            val current = openList.poll()
            val currentId = current.id

            if (currentId == endId) {
                val path = mutableListOf<String>()
                var node: Node? = current
                while (node != null) {
                    path.add(0, node.id)
                    node = node.parent
                }
                return Triple(path, current.g, null)
            }

            if (currentId in closedList) continue
            closedList.add(currentId)

            val neighbors = graph[currentId] ?: emptyList()
            for (neighborPair in neighbors) {
                val neighborId = neighborPair.first
                val edgeCost = neighborPair.second

                if (neighborId in closedList) continue

                var newG = current.g + edgeCost
                if (current.previousNodeId != null && neighborId == current.previousNodeId) {
                    newG += 10f
                }

                val h = binding.mapView.estimateDistance(neighborId, endId).toFloat()
                val newNode = Node(neighborId, newG, h, current, currentId)

                val existingNode = parentMap[neighborId]
                if (existingNode == null || newG < existingNode.g) {
                    parentMap[neighborId] = newNode
                    openList.add(newNode)
                }
            }
        }

        return Triple(emptyList(), 0f, "No path found between $startId and $endId")
    }

    private fun heuristic(start: String, end: String): Float {
        val startNode = binding.mapView.getNodeById(start) ?: binding.mapView.getBuildingById(start)
        val endNode = binding.mapView.getNodeById(end) ?: binding.mapView.getBuildingById(end)

        if (startNode == null || endNode == null) return Float.POSITIVE_INFINITY

        val dx = startNode.x - endNode.x
        val dy = startNode.y - endNode.y
        return kotlin.math.sqrt((dx * dx + dy * dy).toDouble()).toFloat()
    }

    private fun displayPath(path: List<String>, totalCost: Float, startBuilding: String, endBuilding: String, errorMessage: String?) {
        val buildingDescriptions = mapOf(
            "B1" to "Gedung A - Jl. Pucang Anom Timur 10",
            "B2" to "Gedung B - Jl. Pucang Anom Timur I 25",
            "B3" to "Gedung C - Jl. Kalibokor 15",
            "B4" to "Gedung D - Jl. Pucang Rinenggo",
            "B5" to "Gedung E - Jl. Ngagel Jaya Tengah 5",
            "B6" to "Gedung F - Jl. Pucang Anom Timur III",
            "B7" to "Gedung G - Jl. Pucang Asri II",
            "B8" to "Gedung H - Jl. Pucang Asri III",
            "B9" to "Gedung I - Jl. Kalibokor",
            "B10" to "Gedung J - Jl. Ngagel Tama Utara II",
            "B11" to "Gedung K - Jl. Ngagel Tama Utara III",
            "B12" to "Gedung L - Jl. Ngagel Tama Utara IV",
            "B13" to "Gedung M - Jl. Ngagel Jaya Utara"
        )

        if (path.isNotEmpty()) {
            val pathDescription = path.map { id ->
                buildingDescriptions[id] ?: id
            }.joinToString(" -> ")
            binding.pathTextView.text = "Path: $pathDescription\nTotal Distance: $totalCost units"
        } else {
            val startDesc = buildingDescriptions[startBuilding] ?: startBuilding
            val endDesc = buildingDescriptions[endBuilding] ?: endBuilding
            binding.pathTextView.text = "No path found between $startDesc and $endDesc. $errorMessage"
        }
    }
}

