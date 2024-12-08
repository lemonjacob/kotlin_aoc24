import java.io.File
import kotlin.text.Regex

fun main() {
    fun part1(input: String): Int {
        val regex = Regex("""mul\((\d+),(\d+)\)""")
        val matches = regex.findAll(input)
        var sum = 0
        for (match in matches){
            val (num1,num2) = match.destructured
            sum += num1.toInt() * num2.toInt()
        }
        return sum
    }

    fun part2(input: String): Int {

        val regex = Regex("""do\(\)|don't\(\)|mul\((\d+),(\d+)\)""")
        val matches = regex.findAll(input)
        var sum = 0
        var add = true
        for (match in matches){
            if (match.value == "do()"){
                add = true
            }else if(match.value == "don't()"){
                add = false
            }else if(add){
                val (num1,num2) = match.destructured
                sum += num1.toInt() * num2.toInt()
            }

        }
        return sum
    }
    val testInput1 = File("src/input/Day03_test01.txt").readText()
    check(part1(testInput1) == 161)
    val testInput2 = File("src/input/Day03_test02.txt").readText()
    check(part2(testInput2) == 48)

    // Read the input from the `src/Day01.txt` file.
    val input = File("src/input/Day03.txt").readText()
    println(part1(input))
    println(part2(input))
}
