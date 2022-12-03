package solutions.year2022

import readInputLines

fun main() {


    fun getTooPoint(tool: String): Int {
        return (tool.codePointAt(0) - 65) + 1
    }

    fun calculateMatchScore(villainPlay: String, elfPlay: String, useStrategyAsPlay: Boolean): Pair<Int, String?> {
        val victory = mapOf("A" to "B", "B" to "C", "C" to "A")
        val lose = mapOf("C" to "B", "B" to "C", "A" to "B")
        val elfMap = mapOf("X" to "A", "Y" to "B", "Z" to "C")
        return if (useStrategyAsPlay) when (elfMap[elfPlay]) {
            villainPlay -> 3 to elfMap[elfPlay]!!//draw
            victory[villainPlay] -> 6 to elfMap[elfPlay]!!//win
            else -> 0 to elfMap[elfPlay]!! // lose
        }
        else {
            when (elfPlay) {
                "X" -> 0 to lose[villainPlay]!!
                "Z" -> 6 to victory[villainPlay]!!
                else -> 3 to villainPlay
            }
        }

    }

    fun calculateScore(input: List<String>, useStrategyAsPlay: Boolean = true): Int {
        return input.sumOf { round ->
            val (villain, elf) = round.split(" ")
            val matchScore = calculateMatchScore(villain, elf, useStrategyAsPlay)
            return@sumOf matchScore.first + getTooPoint(matchScore.second!!)
        }
    }

    fun part1(input: List<String>): Int {
        return calculateScore(input)
    }

    fun calculateScore2(input: List<String>, withPlay: Boolean): Int {
        val lose = mapOf(1 to 0, 2 to 1, 0 to 2)
        val won = mapOf(0 to 1, 1 to 2, 2 to 0)

        return input.sumOf { round ->
            val (op, result) = round.split(" ").map { it[0].code }
            val opCode = op - 'A'.code
            val meCode = result - 'X'.code

            val (resultScore, playScore) = if (withPlay) {
                when {
                    opCode == meCode -> 3
                    won[opCode]!! == meCode -> 6
                    else -> 0
                } to meCode + 1
            } else {
                3 * meCode to when (meCode) {
                    0 -> lose[opCode]!!
                    1 -> opCode
                    else -> won[opCode]!!
                } + 1
            }

            resultScore + playScore
        }
    }

    fun part2(input: List<String>): Int {
        return calculateScore2(input, false)
    }

    val testInput = readInputLines("2022", "Day2_test")

    val testResult = part1(testInput)
    println(testResult)
    check(testResult != 0)
    check(testResult == 35)

    val testResultPart2 = part2(testInput)
    println(testResultPart2)
    check(testResultPart2 != 0)
    check(testResultPart2 == 27)

    val input = readInputLines("2022", "Day2")
    println(part1(input))
    println(part2(input))

}