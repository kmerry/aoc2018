import kotlin.text.split
import java.io.File

fun day1p1(changeList: List<String>) : Int {
    var ct = 0
    for (change in changeList) ct += change.toInt()
    return ct
}

fun day1p2(changeList: List<String>) : Int {
    val freqsSeen = mutableSetOf(0)

    var ct = 0
    while (true) {
        // Iterate until we find a duplicate
        for (change in changeList) {
            ct += change.toInt()
            if (ct in freqsSeen) return ct
            freqsSeen.add(ct)
        }
    }
}

fun main(args: Array<String>) {
    val examples = arrayOf("+1, +1, +1", "+1, +1, -2", "-1, -2, -3")
    for (inp in examples) {
        println("$inp -> ${day1p1(inp.split(", "))}")
    }

    var ct = 0
    File("test/day1p1.txt").forEachLine { ct += it.toInt() }
    println("day1p1.txt -> $ct")

    val examplesPart2 = arrayOf("+1, -1", "+3, +3, +4, -2, -4", "-6, +3, +8, +5, -6", "+7, +7, -2, -7, -4")
    for (changeList in examplesPart2) {
        println("$changeList -> ${day1p2(changeList.split(", "))}")
    }

    ct = day1p2(File("test/day1p1.txt").readLines())
    println("day1p1.txt -> $ct")
}