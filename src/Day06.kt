fun main() {
    fun part1(input: List<String>): Int {
        val lgm = mutableListOf<MutableList<Char>>()
        var curpos : Pair<Int,Int> = Pair(0,0)
        var visted = mutableSetOf<Pair<Int, Int>>()
        var moving = "UP"
        for (line in input.indices){
            if (input[line].contains("^")){
                curpos = Pair(line,input[line].indexOf("^"))
            }
            lgm.add(input[line].toCharArray().toMutableList())
        }
        while (true){
            if (curpos.first-1>=0 && moving == "UP") {
                visted.add(curpos)
                if (lgm[curpos.first - 1][curpos.second] == '#') {
                    moving = "RIGHT"
                    continue;
                }
                curpos = Pair(curpos.first-1,curpos.second)
            } else if (curpos.second+1<lgm[curpos.first].size && moving == "RIGHT") {
                visted.add(curpos)
                if (lgm[curpos.first][curpos.second+1] == '#') {
                    moving = "DOWN"
                    continue;
                }
                curpos = Pair(curpos.first,curpos.second+1)
            } else if (curpos.first+1<lgm.size && moving == "DOWN") {
                visted.add(curpos)
                if (lgm[curpos.first+1][curpos.second] == '#') {
                    moving = "LEFT"
                    continue;
                }
                curpos = Pair(curpos.first+1,curpos.second)
            } else if (curpos.second-1>=0 && moving == "LEFT") {
                visted.add(curpos)
                if (lgm[curpos.first][curpos.second-1] == '#') {
                    moving = "UP"
                    continue;
                }
                curpos = Pair(curpos.first,curpos.second-1)
            }else{
                visted.add(curpos)
                break
            }


        }
        return visted.size
    }

    fun part2(input: List<String>): Int {
        val lgm = mutableListOf<MutableList<Char>>()
        var curpos : Triple<Int,Int, String> = Triple(0,0,"UP")
        var visted = mutableSetOf<Triple<Int, Int, String>>()
        var starpos : Triple<Int,Int, String> = curpos
        var infinities = 0
        var moving = "UP"
        for (line in input.indices){
            if (input[line].contains("^")){
                starpos = Triple(line,input[line].indexOf("^"),"UP")
            }
            lgm.add(input[line].toCharArray().toMutableList())
        }
        for(i in 0 until lgm.size){
            for(j in 0 until lgm[i].size){
                var tlgm = lgm.map { it.toMutableList() }.toMutableList()
                tlgm[i][j] = '#'
                visted.clear()
                curpos = starpos
                moving = "UP"
                while (true){
                    if (curpos.first-1>=0 && moving == "UP") {
                        visted.add(curpos)
                        if (tlgm[curpos.first - 1][curpos.second] == '#') {
                            moving = "RIGHT"
                            if(visted.contains(Triple(curpos.first,curpos.second+1,moving))){
                                infinities++
                                break
                            }

                            continue;
                        }
                        curpos = Triple(curpos.first-1,curpos.second,moving)
                    } else if (curpos.second+1<tlgm[curpos.first].size && moving == "RIGHT") {
                        visted.add(curpos)
                        if (tlgm[curpos.first][curpos.second+1] == '#') {
                            moving = "DOWN"
                            if(visted.contains(Triple(curpos.first+1,curpos.second,moving))){
                                infinities++
                                break
                            }
                            continue;
                        }
                        curpos = Triple(curpos.first,curpos.second+1,moving)
                    } else if (curpos.first+1<tlgm.size && moving == "DOWN") {
                        visted.add(curpos)
                        if (tlgm[curpos.first+1][curpos.second] == '#') {
                            moving = "LEFT"
                            if(visted.contains(Triple(curpos.first,curpos.second-1,moving))){
                                infinities++
                                break
                            }

                            continue;
                        }
                        curpos = Triple(curpos.first+1,curpos.second,moving)
                    } else if (curpos.second-1>=0 && moving == "LEFT") {
                        visted.add(curpos)
                        if (tlgm[curpos.first][curpos.second-1] == '#') {
                            moving = "UP"
                            if(visted.contains(Triple(curpos.first-1,curpos.second,moving))){
                                infinities++
                                break
                            }

                            continue;
                        }
                        curpos = Triple(curpos.first,curpos.second-1,moving)
                    }else{
                        visted.add(curpos)
                        break
                    }
                }
            }
        }
        return infinities
    }

    check(part1(readInput("test")) == 41)
    check(part2(readInput("test")) == 6)

    val input = readInput("Day06")
    part1(input).println()
    part2(input).println()
}
