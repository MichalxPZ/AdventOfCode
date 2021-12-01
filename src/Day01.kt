fun main() {
    fun part1(input: List<String>): Int {
        var increases = 0;
        val data = input.map { it.toInt() }
        var measurement = data.first()
        for (i in 1..data.size - 1) {
            if (data.get(i) > measurement) {
                increases += 1;
            }
            measurement = data.get(i)
        }
        return increases
    }

    fun part2(input: List<String>): Int {
        val data = input.map { it.toInt() }
        val sums = data.windowed(3, 1)
                .toList()
                .map { it.sum() }
        var measurement = sums.first()
        var increases = 0;
        for (i in 1..sums.size-1) {
            if (sums.get(i) > measurement) {
                increases += 1;
            }
            measurement = sums.get(i)
        }
        return increases
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
