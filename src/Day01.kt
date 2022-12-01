fun main() {
    fun part1(input: List<String>): Int {

        val maxOfOrNull: Int? = input.map { elfBagOfCalories ->
            elfBagOfCalories
                .split("\n")
        }.maxOfOrNull { calories ->
            calories
                .sumOf { calorie -> calorie.toInt() }
        }

        return maxOfOrNull ?: 0
    }

    fun part2(input: List<String>): Int {
        val sumOfCalories: List<Int> = input.map { elfBagOfCalories ->
            elfBagOfCalories
                .split("\n")
        }.map { calories -> calories.sumOf { calorie -> calorie.toInt() } }

        return sumOfCalories.sorted().subList(sumOfCalories.size - 3, sumOfCalories.size).sumOf { it }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) != 0)
    check(part1(testInput) == 3)
    check(part2(testInput) != 0)
    check(part2(testInput) == 6)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
