package com.example.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var graph: Map<String, List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        graph = mapOf(
            "1" to listOf("2", "4"),
            "2" to listOf("1", "3", "5"),
            "3" to listOf("2", "13"),
            "4" to listOf("1", "6", "B3"),
            "5" to listOf("2", "7", "B1"),
            "6" to listOf("4", "8", "B4"),
            "7" to listOf("5", "12", "B2"),
            "8" to listOf("6", "9", "10", "15"),
            "9" to listOf("8", "11", "12", "7"),
            "10" to listOf("8", "11", "14", "15", "B5"),
            "11" to listOf("9", "10", "16"),
            "12" to listOf("7", "9", "13"),
            "13" to listOf("3", "12", "34"),
            "14" to listOf("10", "20", "79"),
            "15" to listOf("8", "10", "21"),
            "16" to listOf("11", "18"),
            "17" to listOf("19", "28", "27A"),
            "18" to listOf("16", "19", "24", "35"),
            "19" to listOf("17", "18", "27"),
            "20" to listOf("14", "21", "23"),
            "21" to listOf("15", "20", "22"),
            "22" to listOf("21", "25"),
            "23" to listOf("20", "26", "27A"),
            "24" to listOf("18", "25", "27"),
            "25" to listOf("22", "24", "26"),
            "26" to listOf("23", "25", "27"),
            "27" to listOf("26", "24", "19", "27A"),
            "27A" to listOf("27", "17", "23", "28"),
            "28" to listOf("17", "29", "34", "27A"),
            "29" to listOf("28", "30"),
            "30" to listOf("29", "31", "33"),
            "31" to listOf("30", "32", "78", "82"),
            "32" to listOf("31", "33", "68"),
            "33" to listOf("30", "32", "40", "44"),
            "34" to listOf("13", "28", "35"),
            "35" to listOf("18", "34"),
            "36" to listOf("37", "80"),
            "37" to listOf("36", "38", "41"),
            "38" to listOf("37", "39", "42"),
            "39" to listOf("38", "40", "43"),
            "40" to listOf("39", "44", "81"),
            "41" to listOf("37", "42"),
            "42" to listOf("38", "41", "43"),
            "43" to listOf("39", "42", "44"),
            "44" to listOf("40", "43", "33"),
            "45" to listOf("44", "46"),
            "46" to listOf("113", "47", "49"),
            "47" to listOf("46", "48"),
            "48" to listOf("47", "49", "58"),
            "49" to listOf("46", "48", "50"),
            "50" to listOf("49", "51", "58", "B5", "B14"),
            "51" to listOf("50", "52", "54"),
            "52" to listOf("51", "53", "55"),
            "53" to listOf("52", "56"),
            "54" to listOf("51", "56", "59"),
            "55" to listOf("52", "58", "60"),
            "56" to listOf("53", "54", "60"),
            "58" to listOf("48", "50", "55", "60"),
            "59" to listOf("54", "60", "83"),
            "60" to listOf("55", "56", "58", "59", "61"),
            "61" to listOf("60", "62", "69", "B17"),
            "62" to listOf("61", "63", "67"),
            "63" to listOf("62", "64", "66"),
            "64" to listOf("63", "65", "68"),
            "65" to listOf("64", "66", "70", "78"),
            "66" to listOf("63", "65", "67"),
            "67" to listOf("62", "66", "70"),
            "68" to listOf("32", "64", "71"),
            "69" to listOf("61", "70"),
            "70" to listOf("65", "67", "69"),
            "71" to listOf("68", "72", "78"),
            "72" to listOf("71", "73", "77"),
            "73" to listOf("72", "74", "76"),
            "74" to listOf("73", "75"),
            "75" to listOf("74", "76"),
            "76" to listOf("73", "75", "77"),
            "77" to listOf("72", "76", "78"),
            "78" to listOf("31", "65", "71", "77", "84"),
            "79" to listOf("14", "80"),
            "80" to listOf("36", "79"),
            "81" to listOf("40", "44"),
            "82" to listOf("31", "50"),
            "83" to listOf("59", "104"),
            "84" to listOf("78", "87"),
            "85" to listOf("30", "86", "95"),
            "86" to listOf("85", "88"),
            "87" to listOf("84", "105"),
            "88" to listOf("86", "89"),
            "89" to listOf("88", "90"),
            "90" to listOf("89", "91"),
            "91" to listOf("90", "92"),
            "92" to listOf("91", "93"),
            "93" to listOf("92", "94"),
            "94" to listOf("93", "105"),
            "95" to listOf("85", "96"),
            "96" to listOf("95", "97"),
            "97" to listOf("96", "98"),
            "98" to listOf("97", "99"),
            "99" to listOf("98", "100"),
            "100" to listOf("99", "101"),
            "101" to listOf("100", "102"),
            "102" to listOf("101", "103"),
            "103" to listOf("102", "104"),
            "104" to listOf("83", "103", "107"),
            "105" to listOf("87", "94", "106"),
            "106" to listOf("105", "107"),
            "107" to listOf("104", "106"),
            "108" to listOf("86","112"),
            "109" to listOf("107", "111"),
            "110" to listOf("109", "111"),
            "111" to listOf("87", "111"),
            "112" to listOf("108", "111"),
            "113" to listOf("46", "33"),
            "B1" to listOf("4", "5"),
            "B2" to listOf("7", "6"),
            "B3" to listOf("4", "5"),
            "B4" to listOf("6", "7"),
            "B5" to listOf("10", "11"),
            "B6" to listOf("10", "11"),
            "B7" to listOf("25", "24"),
            "B8" to listOf("26", "27"),
            "B9" to listOf("23", "27A"),
            "B10" to listOf("41", "37"),
            "B11" to listOf("38", "42"),
            "B12" to listOf("39", "43"),
            "B13" to listOf("40", "44", "39", "43"),
            "B14" to listOf("49", "50", "82"),
            "B15" to listOf("30"),
            "B16" to listOf("104", "107"),
            "B17" to listOf("61", "70"),
            "B18" to listOf("60", "59", "69"),
            "B19" to listOf("51", "82"),
            "B20" to listOf("111", "112"),
            "B21" to listOf("110", "111"),
        )

        val filteredGraph = mutableMapOf<String, List<String>>()
        for ((nodeId, neighbors) in graph) {
            val node = (binding.mapView as MapView).nodes.find { it.id == nodeId } ?: continue
            val validNeighbors = neighbors.filter { neighborId ->
                val neighbor = (binding.mapView as MapView).nodes.find { it.id == neighborId } ?: return@filter false
                !(binding.mapView as MapView).lineIntersectBuilding(node.x, node.y, neighbor.x, neighbor.y)
            }
            filteredGraph[nodeId] = validNeighbors
        }
        graph = filteredGraph

        binding.findPathButton.setOnClickListener {
            val startBuilding = binding.mapView.getStartBuildingId()
            val endBuilding = binding.mapView.getEndBuildingId()

            if (startBuilding != null && endBuilding != null) {
                val (path, errorMessage) = findPathWithAStar(startBuilding, endBuilding)
                binding.mapView.setPath(path)
                displayPath(path, startBuilding, endBuilding, errorMessage)
            } else {
                binding.pathTextView.text = "Please select both start and end buildings."
            }
        }

        binding.resetButton.setOnClickListener {
            binding.mapView.resetSelection()
            binding.pathTextView.text = "Path will be displayed here"
        }
    }

    private data class Node(val id: String, val g: Int, val h: Int, val parent: Node?, val previousNodeId: String?) : Comparable<Node> {
        val f: Int = g + h
        override fun compareTo(other: Node): Int = f.compareTo(other.f)
    }

    private fun findPathWithAStar(startId: String, endId: String): Pair<List<String>, String?> {
        val startIsBuilding = startId.startsWith("B")
        val endIsBuilding = endId.startsWith("B")

        val startNodeId = if (startIsBuilding) {
            binding.mapView.findNearestNode(startId) ?: return Pair(emptyList(), "No nearby node found for start building: $startId")
        } else {
            startId
        }

        val endNodeId = if (endIsBuilding) {
            binding.mapView.findNearestNode(endId) ?: return Pair(emptyList(), "No nearby node found for end building: $endId")
        } else {
            endId
        }

        val openList = PriorityQueue<Node>()
        val closedList = mutableSetOf<String>()
        val parentMap = mutableMapOf<String, Node>()

        val startNode = Node(startNodeId, 0, binding.mapView.estimateDistance(startNodeId, endNodeId), null, null)
        openList.add(startNode)
        parentMap[startNodeId] = startNode

        while (openList.isNotEmpty()) {
            val current = openList.poll()
            val currentId = current.id

            if (currentId == endNodeId) {
                // Step 3: Reconstruct the path between nodes
                val nodePath = mutableListOf<String>()
                var node: Node? = current
                while (node != null) {
                    nodePath.add(0, node.id)
                    node = node.parent
                }

                // Step 4: Add the start and end buildings to the path
                val finalPath = mutableListOf<String>()
                if (startIsBuilding) {
                    finalPath.add(startId) // Add start building
                }
                finalPath.addAll(nodePath) // Add node-to-node path
                if (endIsBuilding) {
                    finalPath.add(endId) // Add end building
                }
                return Pair(finalPath, null) // No error
            }

            if (currentId in closedList) continue
            closedList.add(currentId)

            val neighbors = graph[currentId] ?: emptyList()
            for (neighbor in neighbors) {
                if (neighbor in closedList) continue

                var newG = current.g + 1
                if (current.previousNodeId != null && neighbor == current.previousNodeId) {
                    newG += 10
                }

                val h = binding.mapView.estimateDistance(neighbor, endNodeId)
                val newNode = Node(neighbor, newG, h, current, currentId)

                val existingNode = parentMap[neighbor]
                if (existingNode == null || newG < existingNode.g) {
                    parentMap[neighbor] = newNode
                    openList.add(newNode)
                }
            }
        }

        return Pair(emptyList(), "No path found between $startNodeId and $endNodeId")
    }

    private fun displayPath(path: List<String>, startBuilding: String, endBuilding: String, errorMessage: String?) {
        if (errorMessage != null) {
            binding.pathTextView.text = errorMessage
            return
        }

        if (path.isEmpty()) {
            binding.pathTextView.text = "No path found between $startBuilding and $endBuilding."
            return
        }

        val nodeDescriptions = mapOf(
            "A" to "Jl. Pucang Anom & Jl. Kalibokor",
            "B" to "Jl. Kalibokor & Jl. Kalibokor Timur",
            "C" to "Jl. Kalibokor Timur & Jl. Manyar Air",
            "D" to "Jl. Kalibokor & Jl. Ngagel Jaya Utara",
            "E" to "Jl. Ngagel Jaya Utara & Jl. Ngagel Jaya Tengah",
            "F" to "Jl. Ngagel Jaya Tengah & Jl. Manyar Rejo",
            "G" to "Jl. Bratang Binangun & Jl. Ngagel Jaya Selatan",
            "H" to "Jl. Ngagel Jaya Selatan & Jl. Manyar Rejo",
            "I" to "Jl. Bratang Binangun & Jl. Krukah Binangun Timur",
            "J" to "Jl. Krukah Binangun Timur & Jl. Ngagel Jaya Selatan"
        )

        val pathDescription = path.map { pointId ->
            if (pointId.startsWith("B")) {
                val building = (binding.mapView as MapView).buildings.find { it.id == pointId }
                building?.address ?: pointId
            } else {
                nodeDescriptions[pointId] ?: pointId
            }
        }.joinToString(" -> ")

        binding.pathTextView.text = "Path: $pathDescription"
    }
}