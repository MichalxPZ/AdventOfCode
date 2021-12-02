fun main() {

    fun getMoves(input: List<String>): ArrayList<Pair<String, Int>> {
        val moves: ArrayList<Pair<String, Int>> = arrayListOf()
        input.map {
            val key: String
            val value: Int
            it.split(" ").let {
                key = it.get(0)
                value = it.get(1).toInt()
            }
            moves.add(
                Pair(
                    key,
                    value
                )
            )
        }
        return moves
    }

    fun part1(input: List<String>): Int {
        val submarine = Submarine()
        val moves: ArrayList<Pair<String, Int>> = getMoves(input)
        moves.forEach {
            when(it.first) {
                "forward" -> submarine.changeX(it.second)
                "down" -> submarine.changeZ(it.second)
                "up" -> submarine.changeZ(-it.second)
            }
        }
        return submarine.getX()*submarine.getZ()
    }

    fun part2(input: List<String>): Int {
        val submarine = Submarine()
        val moves: ArrayList<Pair<String, Int>> = getMoves(input)
        moves.forEach {
            when(it.first) {
                "forward" -> {
                    submarine.changeX(it.second)
                    submarine.changeZ(it.second * submarine.getAim())
                }
                "down" -> submarine.changeAim(it.second)
                "up" -> submarine.changeAim(-it.second)
            }
        }
        return submarine.getX()*submarine.getZ()
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}