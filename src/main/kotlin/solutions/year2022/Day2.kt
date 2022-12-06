package solutions.year2022

import readInputLines

private val lose = mapOf(1 to 0, 2 to 1, 0 to 2)
private val won = mapOf(0 to 1, 1 to 2, 2 to 0)

fun main() {


    fun getResultScore(elfCode: Int, villainCode: Int) =
        3 * elfCode to when (elfCode) {
            0 -> lose[villainCode]!!
            1 -> villainCode
            else -> won[villainCode]!!
        } + 1

    fun getResultScoreWithPlay(elfCode: Int, villainCode: Int) = when {
        villainCode == elfCode -> 3
        won[villainCode]!! == elfCode -> 6
        else -> 0
    } to (elfCode + 1)

    fun calculateScore(input: List<String>, withPlay: Boolean = true): Int {
        return input.sumOf { round ->
            val (op, result) = round.split(" ").map { it[0].code }
            val villainCode = op - 'A'.code
            val elfCode = result - 'X'.code

            val (resultScore, playScore) = if (withPlay) {
                getResultScoreWithPlay(villainCode, elfCode)
            } else {
                getResultScore(elfCode, villainCode)
            }

            resultScore + playScore
        }
    }


    fun part1(input: List<String>): Int {
        return calculateScore(input)
    }

    fun part2(input: List<String>): Int {
        return calculateScore(input, false)
    }

    val testInput = readInputLines("2022", "Day2_test")

    val testResult = part1(testInput)
    println(testResult)
    check(testResult != 0)
    check(testResult == 17)

    val testResultPart2 = part2(testInput)
    println(testResultPart2)
    check(testResultPart2 != 0)
    check(testResultPart2 == 27)

    val input = readInputLines("2022", "Day2")
    println(part1(input))
    println(part2(input))

}