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
        sum.println()
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
        sum.println()
        return sum
    }

    // Test if implementation meets criteria from the description, like:

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = File("src/test.txt").readText()
    check(part2(testInput) == 48)

    // Read the input from the `src/Day01.txt` file.
    val input = File("src/input.txt").readText()

    println(part2(input))
}
