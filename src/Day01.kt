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
                if (floors[f] >floors[f+1]) {
                    more = false;
                }
                if (floors[f]<floors[f+1]){
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
                numsafe += 1;
            }
        }
        return numsafe;
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("input")
    part1(input).println()
    part2(input).println()
}
