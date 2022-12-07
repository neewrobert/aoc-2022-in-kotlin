package solutions.year2022

import readInputLines

/**
 * split te pairs
 *
 * compare both to see which if one pair is fully contained in the other
 *
 * count
 */
fun main() {

    fun getSectionRange(line: String): List<IntRange> {
        return line.split(",").map { pairs ->
            val (a, b) = pairs.split("-").map { it.toInt() }
            a..b
        }
    }

    fun part1(input: List<String>): Int {
       return input.map { getSectionRange(it) }.count { (e1, e2) ->
            (e1.first in e2 && e1.last in e2) || (e2.first in e1 && e2.last in e1)
        }
    }

    fun part2(input: List<String>): Int {
        return input.map { getSectionRange(it) }.count{
            (e1, e2) -> e1.first in e2 || e1.last in e2 || e2.first in e1 || e2.last in e1
        }
    }


    val testInput = readInputLines("2022", "Day4_test")
    println(part1(testInput))
    check(part1(testInput) != 0)
    check(part1(testInput) == 2)

    println(part2(testInput))
    check(part2(testInput) != 0)
    check(part2(testInput) == 4)

    val input = readInputLines("2022", "Day4")
    println(part1(input))
    println(part2(input))
}
