import java.io.File
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        input.forEach { line ->
            val reg = Regex("""(\d+)\s*(\d+)""")
            val match = reg.find(line)!!
            list1.add(match.groupValues[1].toInt())
            list2.add(match.groupValues[2].toInt())
        }
        list1.sort()
        list2.sort()
        var sum = 0
        for (i in list1.indices){
            sum += abs(list1[i]-list2[i])
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        input.forEach{
                line ->
            val reg = Regex("""(\d+)\s*(\d+)""")
            val match = reg.find(line)!!
            list1.add(match.groupValues[1].toInt())
            list2.add(match.groupValues[2].toInt())
        }
        list1.sort()
        list2.sort()
        var sum = 0
        for (i in list1){
            var times = 0
            for (j in list2){
                if (i==j){
                    times++
                }
            }
            sum += times*i;
        }
        return sum
    }


    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
