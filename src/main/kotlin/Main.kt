package com.ludvig.repriceanagram

fun main() {
    val words = object {}.javaClass
        .getResourceAsStream("/eventyr.txt")
        ?.bufferedReader()
        ?.readLines()
        ?: error("File not found")

    val grouped = groupAnagrams(words)

    grouped.values
        .filter { it.size > 1 }
        .forEach { println(it.joinToString(" ")) }
}