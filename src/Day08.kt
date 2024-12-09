fun main() {
    fun part1(input: List<String>): Int {
        val antmap = mutableListOf<MutableList<Char>>()
        val antimap = mutableSetOf<Pair<Int, Int>>()
        val antamap = mutableMapOf<Char, MutableList<Pair<Int, Int>>>()
        for (line in input.indices) {
            val row = mutableListOf<Char>()
            for (c in input[line].indices) {
                row.add(input[line][c])
                if (input[line][c]!= '.'){
                    if(antamap[input[line][c]] != null){
                        antamap[input[line][c]]?.add(Pair(line, c))
                    }else{
                        antamap[input[line][c]] = mutableListOf(Pair(line, c))
                    }
                }
            }
            antmap.add(row)
        }
        for (key in antamap.keys){
            for (pair in antamap[key]!!){
                for (pair2 in antamap[key]!!){
                    if (pair == pair2) continue
                    val raise = pair2.first - pair.first
                    val run = pair2.second - pair.second
                    if (pair.first - raise in 0 until antmap.size && pair.second - run in 0 until antmap[pair.first].size) {
                        antimap.add(Pair(pair.first - raise, pair.second - run))
                    }
                    if (pair2.first + raise in 0 until antmap.size && pair2.second + run in 0 until antmap[pair.first].size) {
                        antimap.add(Pair(pair2.first + raise, pair2.second + run))
                    }
                }
            }
        }
        return antimap.size
    }

    fun part2(input: List<String>): Int {
        val antmap = mutableListOf<MutableList<Char>>()
        val antimap = mutableSetOf<Pair<Int, Int>>()
        val antamap = mutableMapOf<Char, MutableList<Pair<Int, Int>>>()
        for (line in input.indices) {
            val row = mutableListOf<Char>()
            for (c in input[line].indices) {
                row.add(input[line][c])
                if (input[line][c]!= '.'){
                    if(antamap[input[line][c]] != null){
                        antamap[input[line][c]]?.add(Pair(line, c))
                    }else{
                        antamap[input[line][c]] = mutableListOf(Pair(line, c))
                    }
                }
            }
            antmap.add(row)
        }
        for (key in antamap.keys){
            for (pair in antamap[key]!!){
                for (pair2 in antamap[key]!!){
                    val raise = pair2.first - pair.first
                    val run = pair2.second - pair.second
                    var current = Pair(pair.first, pair.second)
                    if (pair==pair2) continue
                    while(true){
                        if (current.first !in 0 until antmap.size || current.second !in 0 until antmap[pair.first].size){
                            break
                        } else{
                            antimap.add(current)
                            current = Pair(current.first + raise, current.second + run)
                        }
                    }
                    while(true){
                        if (current.first !in 0 until antmap.size || current.second !in 0 until antmap[pair.first].size){
                            break
                        } else{
                            antimap.add(current)
                            current = Pair(current.first - raise, current.second - run)
                        }
                    }
                }
            }
        }
        return antimap.size
    }

    check(part1(readInput("Day08_test")) == 14)
    check(part2(readInput("Day08_test")) == 34)
    val input = readInput("Day08")
    part1(input).println()
    part2(input).println()
}
