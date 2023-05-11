package com.gamepubjonghwan.tp05unittest

import org.junit.Assert.*
import org.junit.Test

class JUnitTest {

    private val testCalculation = Calculation()

    @Test
    fun add_checkEqual() {
        val expected = 45
        assertEquals(expected, testCalculation.sum(30, 12))
    }

    @Test
    fun difference_checkNotEqual(){
        val expected = 61
        assertNotEquals(expected, testCalculation.difference(80, 20))
    }
}