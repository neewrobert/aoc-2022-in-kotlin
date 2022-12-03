package solutions.year2022

import readInputText

fun main() {
    fun sumCalories(input: String): List<Int> {
        return input.split("\n\n").map { it.lines().sumOf { cal -> cal.toInt() } }
    }

    fun part1(input: String): Int {
        return sumCalories(input).sortedDescending().take(1).sum()
    }

    fun part2(input: String): Int {
        return sumCalories(input).sortedDescending().take(3).sum()
    }


    val testInput = readInputText("Day1_test", "2022")
    check(part1(testInput) != 0)
    check(part1(testInput) == 4)
    check(part2(testInput) != 0)
    check(part2(testInput) == 9)

    val input = readInputText("Day1", "2022")
    println(part1(input))
    println(part2(input))
}
