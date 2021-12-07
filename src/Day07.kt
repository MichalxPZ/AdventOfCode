import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val base = input.get(0).split(",").map { it.toString().toInt() }
        var max = 0
        for (i in base) {
            if (i > max) max = i
        }
        var fuel = max*base.size
        for (i in 0..max) {
            var actualFuel = 0;
            for (num in base) {
                actualFuel += abs(num-i)
            }
            if (fuel > actualFuel) {
                fuel = actualFuel
            }
        }
        return fuel
    }

    fun part2(input: List<String>): Int {
        val base = input.get(0).split(",").map { it.toString().toInt() }
        var max = 0
        for (i in base) {
            if (i > max) max = i
        }
        var fuel = sum(max)*base.size
        for (i in 0..max) {
            var actualFuel = 0;
            for (num in base) {
                actualFuel += sum(abs(num-i))
            }
            if (fuel > actualFuel) {
                fuel = actualFuel
            }
        }
        println(fuel)
        return fuel
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 37)
    check(part2(testInput) == 168)

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}

fun sum(n: Int): Int {
    var res = 0
    for (i in 1..n) {
        res += i
    }
    return res
}
