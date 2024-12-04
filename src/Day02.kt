import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var numsafe = 0
        for (line in input) {
            val floors = line.split(" ")
            var less = true;
            var more = true;
            var safe = true;
            for (f in 0 until floors.size -1) {
                if (floors[f].toInt() >=floors[f+1].toInt()) {
                    more = false;
                }
                if (floors[f].toInt()<=floors[f+1].toInt()){
                    less = false;
                }

            }
            if (less || more){
                for(f in 0 until floors.size-1) {
                    if (abs(floors[f].toInt()-floors[f+1].toInt()) !in 1..3){
                        safe = false;
                    }
                }
            }else{
                safe = false;
            }
            if (safe){
                numsafe++
            }
        }
        return numsafe;
    }

    fun part2(input: List<String>): Int {
        var numsafe = 0
        for (line in input) {
            val floors = line.split(" ")
            var safe = false
            for (i in floors.indices) {
                val modifiedFloors = floors.toMutableList()
                modifiedFloors.removeAt(i)
                var list = listOf<String>();
                list+=modifiedFloors.joinToString(" ")
                if (part1(list)==1) {
                    safe = true
                    break
                }
            }
            if (safe) {
                numsafe += 1
            }
        }
        return numsafe
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(readInput("Day02_test")) == 2)
    check(part2(readInput("Day02_test")) == 4)
    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
