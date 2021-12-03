import com.sun.source.tree.ReturnTree
import java.lang.Math.pow

fun main() {
    fun part1(input: List<String>) : Int {
        var gammaRateInString: String = ""
        var epsilonRateInString: String = ""
        val tab: ArrayList<Int> = generateAppearencesTab(input)
        for (index in 0..tab.size-1) {
            if (tab.get(index) > 0) {
                gammaRateInString += "1"
                epsilonRateInString += "0"
            } else {
                gammaRateInString += "0"
                epsilonRateInString += "1"
            }
        }
//        println(binStrToDec(gammaRateInString) * binStrToDec(epsilonRateInString))
        return binStrToDec(gammaRateInString) * binStrToDec(epsilonRateInString)
    }

    fun part2(input: List<String>): Int {
        val tab: ArrayList<Int> = generateAppearencesTab(input)
        val oxygenGenerator: Int = binStrToDec(findGeneratorRating(true, input, tab))
        val carbonGenerator: Int = binStrToDec(findGeneratorRating(false, input, tab))
        println(oxygenGenerator)
        println(carbonGenerator)
        return oxygenGenerator*carbonGenerator;
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

fun findGeneratorRating(mostCommon: Boolean, input: List<String>, appearences: ArrayList<Int>): String {
    var result: List<String> = input
    var app = arrayListOf<Int>()
    for (position in 0..input.get(0).length-1) {
        if (result.size <= 1) break
        var sign: Int
        app = generateAppearencesTab(result)
        if (mostCommon) {
            if (app.get(position) >= 0) {
                sign = 1
            } else sign = 0
        } else {
            if (app.get(position) < 0) {
                sign = 1
            } else sign = 0
        }
        result = result.filter {
            it.get(position).toString().toInt() == sign
        }
    }
    return result.get(0)
}

fun generateAppearencesTab(input: List<String>): ArrayList<Int> {
    var tab: ArrayList<Int> = arrayListOf()
    for (position in 0..input.get(0).length - 1) {
        tab.add(0)
    }
    for (number in input) {
        for (bit in 0..number.length - 1) {
            if (number.get(bit) == '0') {
                tab.set(bit, tab.get(bit) - 1)
            } else {
                tab.set(bit, tab.get(bit) + 1)
            }
        }
    }
    return tab
}

fun binStrToDec(binary: String): Int {
    var dec = 0
    for (index in 0..binary.length-2) {
        dec += pow(2*binary.get(index).toString().toDouble(), (binary.length-1-index).toDouble()).toInt()
    }
    if (binary.last() == '1') {
        dec += 1
    }
    return dec;
}


