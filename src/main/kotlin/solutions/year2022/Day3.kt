package solutions.year2022

import readInputLines

/**
 * For each element you should split it on half = input.size() / 2
 *
 * compare both to see which element appears more than once
 *
 * check the priority and save it
 *
 * sum up all the priority
 */
fun main() {

    fun Char.toPriority() = if (this in 'a'..'z') this.code - 'a'.code + 1 else this.code - 'A'.code + 27

    fun part1(input: List<String>): Int {
        return input.sumOf { rucksack ->
            val half = rucksack.length / 2
            val (firstHalf, secondHalf) = rucksack.chunked(half)
            firstHalf.find { it in secondHalf }?.toPriority() ?: 0
        }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3).sumOf { group ->
            val (g1, g2, g3) = group
            g1.find { it in g2 && it in g3 }?.toPriority() ?: 0
        }
    }


    val testInput = readInputLines("2022", "Day3_test")
    check(part1(testInput) != 0)
    check(part1(testInput) == 97)
    check(part2(testInput) != 0)
    check(part2(testInput) == 38)

    val input = readInputLines("2022", "Day3")
    println(part1(input))
    println(part2(input))
}
