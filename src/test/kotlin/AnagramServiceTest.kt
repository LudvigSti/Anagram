package com.ludvig.repriceanagram

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AnagramTest {

    @Test
    fun signature_should_sort_characters_alphabetically() {
        assertEquals("eilnst", anagramSignatureSorted("listen"))
    }

    @Test
    fun grouping_should_map_word_to_signture() {
        val words = listOf("listen", "silent", "cat", "act")

        val grouped = groupAnagramsBySorted(words)

        assertTrue(grouped["eilnst"]!!.containsAll(listOf("listen", "silent")))
    }

    @Test
    fun signature2_should_be_identical_for_anagrams() {
        assertEquals(
            anagramSignatureFrequency("søå"),
            anagramSignatureFrequency("øså")
        )
    }
}