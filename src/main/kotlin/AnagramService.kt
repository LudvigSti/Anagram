package com.ludvig.repriceanagram

fun signature(word: String): String =
    word.toCharArray().sorted().joinToString("")

fun groupAnagrams(words: List<String>): Map<String, List<String>> =
    words.groupBy { signature(it) }

fun signature2(word: String): String {
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

fun groupAnagrams2(words: List<String>): Map<String, List<String>> =
    words.groupBy { signature2(it) }