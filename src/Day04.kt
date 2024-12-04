fun main() {
    fun part1(input: List<String>): Int {
        var xmasCount = 0
        val ws = mutableListOf<List<Char>>()
        input.forEach {
            a ->
            ws.add(a.toCharArray().toList())
        }
        for (r in ws.indices){
            for (c in ws[r].indices){
                if (ws[r][c] == 'X'){
                    if(c+3<ws[r].size){
                        if(ws[r][c+1] == 'M'&&ws[r][c+2] == 'A'&&ws[r][c+3] == 'S'){
                            xmasCount++
                        }
                    }
                    if (c-3>=0){
                        if(ws[r][c-1] == 'M' && ws[r][c-2] == 'A'&&ws[r][c-3] == 'S'){
                            xmasCount++
                        }
                    }
                    if (r+3<ws.size){
                        if(ws[r+1][c] == 'M' && ws[r+2][c] == 'A'&&ws[r+3][c] == 'S'){
                            xmasCount++
                        }
                    }
                    if (r-3>=0){
                        if(ws[r-1][c] == 'M' && ws[r-2][c] == 'A'&&ws[r-3][c] == 'S') {
                            xmasCount++
                        }
                    }
                    if (r+3<ws.size && c+3<ws[r].size){
                        if(ws[r+1][c+1] == 'M' && ws[r+2][c+2] == 'A'&&ws[r+3][c+3] == 'S'){
                            xmasCount++
                        }
                    }
                    if (r-3>=0 && c-3>=0){
                        if(ws[r-1][c-1] == 'M' && ws[r-2][c-2] == 'A'&&ws[r-3][c-3] == 'S'){
                            xmasCount++
                        }
                    }
                    if (r+3<ws.size && c-3>=0){
                        if(ws[r+1][c-1] == 'M' && ws[r+2][c-2] == 'A'&&ws[r+3][c-3] == 'S'){
                            xmasCount++
                        }
                    }
                    if (r-3>=0 && c+3<ws[r].size){
                        if(ws[r-1][c+1] == 'M' && ws[r-2][c+2] == 'A'&&ws[r-3][c+3] == 'S'){
                            xmasCount++
                        }
                    }
                }
            }
        }
        return xmasCount
    }

    fun part2(input: List<String>): Int {
        var xmasCount = 0
        val ws = mutableListOf<List<Char>>()
        input.forEach { a ->
            ws.add(a.toCharArray().toList())
        }
        for (r in ws.indices) {
            for (c in ws[r].indices) {
                if (ws[r][c] == 'A') {
                    if (c - 1 >= 0 && c + 1 < ws[r].size && r - 1 >= 0 && r + 1 < ws.size) {
                        if (ws[r - 1][c - 1] == 'M' && ws[r - 1][c + 1] == 'S' && ws[r + 1][c - 1] == 'M' && ws[r + 1][c + 1] == 'S') {
                            xmasCount++
                        }
                        if (ws[r - 1][c - 1] == 'M' && ws[r - 1][c + 1] == 'M' && ws[r + 1][c - 1] == 'S' && ws[r + 1][c + 1] == 'S') {
                            xmasCount++
                        }
                        if (ws[r - 1][c - 1] == 'S' && ws[r - 1][c + 1] == 'S' && ws[r + 1][c - 1] == 'M' && ws[r + 1][c + 1] == 'M') {
                            xmasCount++
                        }
                        if (ws[r - 1][c - 1] == 'S' && ws[r - 1][c + 1] == 'M' && ws[r + 1][c - 1] == 'S' && ws[r + 1][c + 1] == 'M') {
                            xmasCount++
                        }
                    }
                }

            }

        }
        return xmasCount
    }
    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("test")
    check(part1(testInput) == 18)
    check(part2(testInput) == 9)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("input")
    part1(input).println()
    part2(input).println()
}