fun main() {
    fun part1(input: List<String>): Int {
        var trail = mutableListOf<List<Int>>()
        var starts = mutableListOf<Pair<Int, Int>>()
        var sum = 0
        for (line in input.indices){
            val a  = mutableListOf<Int>()
            for (char in input[line].indices){
                a.add(input[line][char].toString().toInt())
                if (input[line][char] == '0'){
                    starts.add(Pair(line, char))
                }
            }
            trail.add(a)
        }
        for (start in starts) {
            var checks = mutableSetOf<Pair<Int, Int>>(start)
            var nines = mutableSetOf<Pair<Int,Int>>()
            while (checks.isNotEmpty()) {
                val current = checks.first()
                checks.remove(current)
                if (current.first - 1 >= 0) {
                    if (trail[current.first - 1][current.second] == trail[current.first][current.second] + 1) {
                        if (trail[current.first - 1][current.second] == 9) {
                            nines.add(Pair(current.first - 1, current.second))
                        } else {
                            checks.add(Pair(current.first - 1, current.second))
                        }
                    }

                }
                if (current.first + 1 < trail.size) {
                    if (trail[current.first + 1][current.second] == trail[current.first][current.second] + 1) {
                        if (trail[current.first + 1][current.second] == 9) {
                            nines.add(Pair(current.first +1, current.second))
                        } else {
                            checks.add(Pair(current.first + 1, current.second))
                        }
                    }
                }
                if (current.second - 1 >= 0) {
                    if (trail[current.first][current.second - 1] == trail[current.first][current.second] + 1) {
                        if (trail[current.first][current.second - 1] == 9) {
                            nines.add(Pair(current.first, current.second -1))
                        } else {
                            checks.add(Pair(current.first, current.second - 1))
                        }
                    }
                }
                if (current.second + 1 < trail[current.first].size) {
                    if (trail[current.first][current.second + 1] == trail[current.first][current.second] + 1) {
                        if (trail[current.first][current.second + 1] == 9) {
                            nines.add(Pair(current.first, current.second+1))
                        } else {
                            checks.add(Pair(current.first, current.second + 1))
                        }
                    }
                }
            }
            sum+=nines.size
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var trail = mutableListOf<List<Int>>()
        var starts = mutableListOf<Pair<Int, Int>>()
        var sum = 0
        for (line in input.indices){
            val a  = mutableListOf<Int>()
            for (char in input[line].indices){
                a.add(input[line][char].toString().toInt())
                if (input[line][char] == '0'){
                    starts.add(Pair(line, char))
                }
            }
            trail.add(a)
        }
        for (start in starts) {
            var checks = mutableSetOf<Pair<Int, Int>>(start)
            var nines = mutableSetOf<Pair<Int,Int>>()
            while (checks.isNotEmpty()) {
                val current = checks.first()
                checks.remove(current)
                var num = 0
                if (current.first - 1 >= 0) {
                    if (trail[current.first - 1][current.second] == trail[current.first][current.second] + 1) {
                        num++
                        if (trail[current.first - 1][current.second] == 9) {
                            nines.add(Pair(current.first - 1, current.second))
                        } else {
                            checks.add(Pair(current.first - 1, current.second))
                        }
                    }

                }
                if (current.first + 1 < trail.size) {
                    if (trail[current.first + 1][current.second] == trail[current.first][current.second] + 1) {
                        num++
                        if (trail[current.first + 1][current.second] == 9) {
                            nines.add(Pair(current.first +1, current.second))
                        } else {
                            checks.add(Pair(current.first + 1, current.second))
                        }
                    }
                }
                if (current.second - 1 >= 0) {
                    if (trail[current.first][current.second - 1] == trail[current.first][current.second] + 1) {
                        num++
                        if (trail[current.first][current.second - 1] == 9) {
                            nines.add(Pair(current.first, current.second -1))
                        } else {
                            checks.add(Pair(current.first, current.second - 1))
                        }
                    }
                }
                if (current.second + 1 < trail[current.first].size) {
                    if (trail[current.first][current.second + 1] == trail[current.first][current.second] + 1) {
                        num++
                        if (trail[current.first][current.second + 1] == 9) {
                            nines.add(Pair(current.first, current.second+1))
                        } else {
                            checks.add(Pair(current.first, current.second + 1))
                        }
                    }
                }
                if(num>1){
                    sum+=num-1
                }
            }
            sum+=nines.size
        }
        sum.println()
        return sum
    }

    check(part1(readInput("test")) == 36)
    check(part2(readInput("test")) == 81)

    val input = readInput("input")
    part1(input).println()
    part2(input).println()
}
