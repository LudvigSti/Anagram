package com.ludvig.repriceanagram

fun signature(word: String): String =
    word.toCharArray().sorted().joinToString("")

fun groupAnagrams(words: List<String>): Map<String, List<String>> =
    words.groupBy { signature(it) }