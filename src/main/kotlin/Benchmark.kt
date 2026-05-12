package com.ludvig.repriceanagram

import kotlin.system.measureTimeMillis

fun benchmarkAnagramAlgorithms() {
    val words = object {}.javaClass
        .getResourceAsStream("/eventyr.txt")
        ?.bufferedReader()
        ?.readLines()
        ?: error("File not found")

    repeat(3) {
        groupAnagramsBySorted(words)
        groupAnagramsByFrequency(words)
    }

    val sortedTime = measureTimeMillis {
        repeat(5) {
            groupAnagramsBySorted(words)
        }
    }

    val frequencyTime = measureTimeMillis {
        repeat(5) {
            groupAnagramsByFrequency(words)
        }
    }

    println("=== Benchmark results ===")
    println("Sorted method: $sortedTime ms")
    println("Frequency method: $frequencyTime ms")

}

fun main() {
    benchmarkAnagramAlgorithms()
}