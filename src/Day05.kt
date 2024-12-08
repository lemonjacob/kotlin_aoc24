fun main() {
    fun part1(input: List<String>): Int {
        val rules = mutableListOf<String>()
        var sum = 0
        var add : Boolean
        for (line in input) {
            add = true
            if(line.contains("|")){
                rules.add(line)
            }else if(line.contains(",")){
                val li = line.split(",")
                for (rule in rules){
                    val r = rule.split("|")
                    if(li.contains(r[0]) && li.contains(r[1])){
                        if(li.indexOf(r[0])>li.indexOf(r[1])){
                            add = false
                        }
                    }
                }
                if(add){
                    sum+=li[li.size/2].toInt()
                }
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        fun check(input : MutableList<String>, rules : MutableList<String>) : MutableList<String>{
            for (rule in rules){
                val r = rule.split("|")
                if(input.contains(r[0]) && input.contains(r[1])){
                    if(input.indexOf(r[0])>input.indexOf(r[1])){
                        val temp = input[input.indexOf(r[0])]
                        input[input.indexOf(r[0])] = input[input.indexOf(r[1])]
                        input[input.indexOf(r[1])] = temp
                        check(input,rules)
                    }
                }
            }
            return input
        }


        val rules = mutableListOf<String>()
        var sum = 0
        var add : Boolean
        for (line in input) {
            add = false
            if(line.contains("|")){
                rules.add(line)
            }else if(line.contains(",")){
                var li = line.split(",")
                for (rule in rules){
                    val r = rule.split("|")
                    if(li.contains(r[0]) && li.contains(r[1])){
                        if(li.indexOf(r[0])>li.indexOf(r[1])){
                            add = true
                            li = check(li.toMutableList(),rules)
                            break
                        }
                    }
                }
                if(add){
                    sum+=li[li.size/2].toInt()
                }
            }
        }
        return sum
    }

    check(part1(readInput("Day05_test")) == 143)
    check(part2(readInput("Day05_test")) == 123)

    val input = readInput("Day05")
    part1(input).println()
    part2(input).println()
}
