package solutions.year2022

import readInputLines


fun main() {

    fun moveLines(moveLines: List<String>, onePerMove: Boolean, stacks: Array<ArrayDeque<Char>>) {
        moveLines.forEach { line ->
            val parts = line.split(" ")
            val numCrates = parts[1].toInt()
            val from = parts[3].toInt() - 1
            val to = parts[5].toInt() - 1

            if (onePerMove) {
                repeat(numCrates) {
                    val crate = stacks[from].removeLast()
                    stacks[to].addLast(crate)
                }
            } else {
                var order = ""
                repeat(numCrates) { order += stacks[from].removeLast() }
                order.reversed().forEach(stacks[to]::addLast)
            }
        }
    }

    fun moveCrates(input: List<String>, onePerMove: Boolean): String {
        val stackLines = input.filter { '[' in it }
        val moveLines = input.filter { it.startsWith('m') }

        val stacks = Array((stackLines.maxOf { it.length } + 1) / 4) {
            ArrayDeque<Char>()
        }

        stackLines.forEach { line ->
            val crates = "$line ".chunked(4).map { it.trim() }
            crates.forEachIndexed { stack, crate ->
                if (crate.isNotEmpty()) {
                    stacks[stack].addFirst(crate[1])
                }
            }
        }

        moveLines(moveLines, onePerMove, stacks)

        return stacks.map { it.last() }.joinToString("")
    }


    fun part1(input: List<String>): String {
        return moveCrates(input, true)
    }

    fun part2(input: List<String>): String {
        return moveCrates(input, false)
    }


    val testInput = readInputLines("2022", "Day5_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInputLines("2022", "Day5")
    println(part1(input))
    println(part2(input))
}