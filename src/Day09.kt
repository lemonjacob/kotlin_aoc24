import java.io.File

fun main() {
    fun part1(input: String): Long {
        var space = false
        var disk = mutableListOf<String>()
        var count = 0
        var sum : Long = 0
        for (char in input){
            if (space){
                for(n in 0 until char.toString().toInt()){
                    disk.add(".")
                }
                space=false
            }else{
                for(n in 0 until char.toString().toInt()){
                    disk.add(count.toString())
                }
                space=true
                count++
            }
        }
        for (i in disk.indices){
            if(disk[i] == ".") {
                var swap = disk.size-1
                while (true) {
                    if(swap == i){
                        break
                    }
                    if (disk[swap] != ".") {
                        disk[i] = disk[swap]
                        disk[swap] = "."
                        break
                    }
                    swap--
                }
            }
        }
        for (i in disk.indices){
            if(disk[i] != ".") {
                sum+= disk[i].toInt()*i
            }
        }
        return sum
    }

    fun part2(input: String): Long {
        var space = false
        val disk = mutableListOf<Int>()
        var count = 0
        var sum: Long = 0
        for (char in input) {
            val num = char - '0'
            if (space) {
                repeat(num) {
                    disk.add(-1)
                }
                space = false
            } else {
                repeat(num) {
                    disk.add(count)
                }
                space = true
                count++
            }
        }

        var current = disk.last()
        while (current > 0) {
            var i = 0
            val positions = disk.withIndex().filter { it.value == current }.map { it.index }
            val num = positions.size
            val start = positions.first()

            while (i < disk.size) {
                if (disk[i] == -1) {
                    var dotCount = 0
                    while (i + dotCount < disk.size && disk[i + dotCount] == -1) {
                        dotCount++
                    }
                    if (dotCount >= num && i < start) {
                        for (n in positions) {
                            disk[n] = -1
                        }
                        for (n in 0 until num) {
                            disk[i + n] = current
                        }
                        break
                    }
                    i += dotCount
                } else {
                    i++
                }
            }
            current--
        }

        for (i in disk.indices) {
            if (disk[i] != -1) {
                sum += disk[i] * i
            }
        }
        return sum
    }

    check(part1(File("src/input/Day09_test.txt").readText()) == 1928.toLong())
    check(part2(File("src/input/Day09_test.txt").readText()) == 2858.toLong())
    val input = File("src/input/Day09.txt").readText()
    part1(input).println()
    part2(input).println()

}
