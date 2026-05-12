package com.ludvig.repriceanagram

fun anagramSignatureSorted(word: String): String =
    word.toCharArray().sorted().joinToString("")

fun groupAnagramsBySorted(words: List<String>): Map<String, List<String>> =
    words.groupBy { anagramSignatureSorted(it) }

fun anagramSignatureFrequency(word: String): String {
    val counts = mutableMapOf<Char, Int>()

    for (c in word.lowercase()) {
        counts[c] = counts.getOrDefault(c, 0) + 1
    }

    return counts.toSortedMap()
        .entries
        .joinToString("#") { (char, count) ->
            "$char$count"
        }
}

fun groupAnagramsByFrequency(words: List<String>): Map<String, List<String>> =
    words.groupBy { anagramSignatureFrequency(it) }