import kotlin.text.Regex

fun main() {
    fun part1(input: String): Int {
        val regex = Regex("mul\\(\\d+,\\d+\\)")
        println(regex.findAll(input).first())
        return 1
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
    check(part1(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.

}
