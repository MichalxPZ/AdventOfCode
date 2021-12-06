fun main() {

    fun part1(input: List<String>, days: Int): Int {
        var rybki = input.get(0).split(",").map { it.toString().toInt() } as ArrayList
        for (day in 1..days) {
            var addRybkis = arrayListOf<Int>()
            rybki.forEachIndexed { index, it ->
                if (it == 0) {
                    rybki.set(index, 6)
                    addRybkis.add(8)
                } else {
                    rybki.set(index, it-1)
                }
            }
            addRybkis.forEach {
                rybki.add(it)
            }
        }
        return rybki.size
    }
    fun part2(input: List<String>, days: Int): Long {
        val rybki = input.get(0).split(",").map { it.toString().toInt() } as ArrayList
        var fishMap: HashMap<Int, Long> = hashMapOf()
        for (i in 0..7) {
            fishMap.put(i, 0)
        }
        rybki.forEach {
            fishMap[it] = (fishMap[it]?: 0) + 1
        }
        repeat(days) {
            val newFIsh = fishMap[0]?: 0
            for (daysLeft in 0..7){
                fishMap[daysLeft] = fishMap[daysLeft+1]?: 0
            }
            fishMap[8] = newFIsh
            fishMap[6] = (fishMap[6]?: 0) + newFIsh
        }
        return fishMap.values.sum()
    }


    val testInput = readInput("Day06_test")
    check(part1(testInput, 80) == 5934)
    check(part2(testInput, 256) == 26984457539)

    val input = readInput("Day06")
    println(part1(input, 80))
    println(part2(input, 256))
}
