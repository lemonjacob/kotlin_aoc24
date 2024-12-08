fun main() {
    fun part1(input: List<String>): Int {
        val lgm = mutableListOf<MutableList<Char>>()
        var current : Pair<Int,Int> = Pair(0,0)
        var visited = mutableSetOf<Pair<Int, Int>>()
        var moving = "UP"
        for (line in input.indices){
            if (input[line].contains("^")){
                current = Pair(line,input[line].indexOf("^"))
            }
            lgm.add(input[line].toCharArray().toMutableList())
        }
        while (true){
            if (current.first-1>=0 && moving == "UP") {
                visited.add(current)
                if (lgm[current.first - 1][current.second] == '#') {
                    moving = "RIGHT"
                    continue
                }
                current = Pair(current.first-1,current.second)
            } else if (current.second+1<lgm[current.first].size && moving == "RIGHT") {
                visited.add(current)
                if (lgm[current.first][current.second+1] == '#') {
                    moving = "DOWN"
                    continue
                }
                current = Pair(current.first,current.second+1)
            } else if (current.first+1<lgm.size && moving == "DOWN") {
                visited.add(current)
                if (lgm[current.first+1][current.second] == '#') {
                    moving = "LEFT"
                    continue
                }
                current = Pair(current.first+1,current.second)
            } else if (current.second-1>=0 && moving == "LEFT") {
                visited.add(current)
                if (lgm[current.first][current.second-1] == '#') {
                    moving = "UP"
                    continue
                }
                current = Pair(current.first,current.second-1)
            }else{
                visited.add(current)
                break
            }


        }
        return visited.size
    }

    fun part2(input: List<String>): Int {
        val lgm = mutableListOf<MutableList<Char>>()
        var current : Triple<Int,Int, String> = Triple(0,0,"UP")
        var visited = mutableSetOf<Triple<Int, Int, String>>()
        var start : Triple<Int,Int, String> = current
        var infinities = 0
        var moving = "UP"
        for (line in input.indices){
            if (input[line].contains("^")){
                start = Triple(line,input[line].indexOf("^"),"UP")
            }
            lgm.add(input[line].toCharArray().toMutableList())
        }
        for(i in 0 until lgm.size){
            for(j in 0 until lgm[i].size){
                var tlgm = lgm.map { it.toMutableList() }.toMutableList()
                tlgm[i][j] = '#'
                visited.clear()
                current = start
                moving = "UP"
                while (true){
                    if (current.first-1>=0 && moving == "UP") {
                        visited.add(current)
                        if (tlgm[current.first - 1][current.second] == '#') {
                            moving = "RIGHT"
                            if(visited.contains(Triple(current.first,current.second+1,moving))){
                                infinities++
                                break
                            }

                            continue
                        }
                        current = Triple(current.first-1,current.second,moving)
                    } else if (current.second+1<tlgm[current.first].size && moving == "RIGHT") {
                        visited.add(current)
                        if (tlgm[current.first][current.second+1] == '#') {
                            moving = "DOWN"
                            if(visited.contains(Triple(current.first+1,current.second,moving))){
                                infinities++
                                break
                            }
                            continue
                        }
                        current = Triple(current.first,current.second+1,moving)
                    } else if (current.first+1<tlgm.size && moving == "DOWN") {
                        visited.add(current)
                        if (tlgm[current.first+1][current.second] == '#') {
                            moving = "LEFT"
                            if(visited.contains(Triple(current.first,current.second-1,moving))){
                                infinities++
                                break
                            }

                            continue
                        }
                        current = Triple(current.first+1,current.second,moving)
                    } else if (current.second-1>=0 && moving == "LEFT") {
                        visited.add(current)
                        if (tlgm[current.first][current.second-1] == '#') {
                            moving = "UP"
                            if(visited.contains(Triple(current.first-1,current.second,moving))){
                                infinities++
                                break
                            }

                            continue
                        }
                        current = Triple(current.first,current.second-1,moving)
                    }else{
                        visited.add(current)
                        break
                    }
                }
            }
        }
        return infinities
    }

    check(part1(readInput("Day06_test")) == 41)
    check(part2(readInput("Day06_test")) == 6)

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}
