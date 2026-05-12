package com.ludvig.repriceanagram

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AnagramTest {

    @Test
    fun signature_should_sort_characters_alphabetically() {
        assertEquals("eilnst", signature("listen"))
    }

    @Test
    fun grouping_should_map_word_to_signture() {
        val words = listOf("listen", "silent", "cat", "act")

        val grouped = groupAnagrams(words)

        assertTrue(grouped["eilnst"]!!.containsAll(listOf("listen", "silent")))
    }

    @Test
    fun signature2_should_be_identical_for_anagrams() {
        assertEquals(
            signature2("søå"),
            signature2("øså")
        )
    }

    @Test
    fun grouping_should_work_with_signature2() {
        val words = listOf("listen", "silent", "cat", "act")

        val grouped = words.groupBy { signature2(it) }

        val key = signature2("listen")

        assertTrue(grouped[key]!!.containsAll(listOf("listen", "silent")))
    }
}