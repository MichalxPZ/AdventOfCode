fun main() {
    fun part1(input: String): Int {
        val data = loadData(input)
        return 0
    }

    fun part2(input: String): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test").toString()
    check(part1(testInput) == 4512)
    check(part2(testInput) == 0)

    val input = readInput("Day04").toString()
    println(part1(input))
    println(part2(input))

}

fun loadData(inout: String) {
    println(inout.split("\n"))
}