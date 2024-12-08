import kotlin.math.pow
fun main() {
    fun part1(input: List<String>): Long {
        var resum : Long = 0
        for (line in input) {
            val num = line.substring(0, line.indexOf(':'))
            val nums = (line.substring(line.indexOf(':') + 2)).split(" ")
            val operate = listOf('*', '+')
            var combos = mutableListOf<MutableList<Char>>()
            for (i in 0..2.0.pow(nums.size.toDouble()-1).toInt()-1) {
                val lis = mutableListOf<Char>()
                for (n in 0..nums.size - 2) {
                    when ((i / 2.0.pow(n.toDouble()).toInt()) % 2) {
                        0 -> lis.add(operate[0])
                        1 -> lis.add(operate[1])
                    }
                }
                combos.add(lis)
            }
            for (combo in combos){
                var sum : Long =0
                for (i in 0 until nums.size){
                    if (i == 0){
                        sum = nums[i].toLong()
                    }else if (combo[i-1] == '+'){
                            sum += nums[i].toLong()
                    }else{
                        sum *= nums[i].toLong()
                    }
                }
                if (sum.toLong() == num.toLong()){
                    resum +=num.toLong()
                    break
                }
            }
        }
        return resum
    }

    fun part2(input: List<String>): Long {
        var resum: Long = 0
        for (line in input) {
            val num = line.substring(0, line.indexOf(':'))
            val nums = (line.substring(line.indexOf(':') + 2)).split(" ")
            val operate = listOf('*', '+', '|')
            var combos = mutableListOf<MutableList<Char>>()
            for (i in 0..3.0.pow(nums.size.toDouble() - 1).toInt() - 1) {
                val lis = mutableListOf<Char>()
                for (n in 0..nums.size - 2) {
                    when ((i / 3.0.pow(n.toDouble()).toInt()) % 3) {
                        0 -> lis.add(operate[0])
                        1 -> lis.add(operate[1])
                        2 -> lis.add(operate[2])
                    }
                    combos.add(lis)
                }
            }
            for (combo in combos) {
                var sum: Long = 0
                for (i in 0 until nums.size) {
                    if (i == 0) {
                        sum = nums[i].toLong()
                    } else if (combo[i - 1] == '+') {
                        sum += nums[i].toLong()
                    } else if (combo[i-1] == '*') {
                        sum *= nums[i].toLong()
                    } else{
                        sum = (sum.toString()+nums[i].toString()).toLong()
                    }
                }
                if (sum.toLong() == num.toLong()) {
                    resum += num.toLong()
                    break
                }
            }
        }
        return resum
    }

    check(part1(readInput("Day07_test")) == 3749.toLong())
    check(part2(readInput("Day07_test")) == 11387.toLong())
    val input = readInput("Day07")
    part1(input).println()
    part2(input).println()
}
