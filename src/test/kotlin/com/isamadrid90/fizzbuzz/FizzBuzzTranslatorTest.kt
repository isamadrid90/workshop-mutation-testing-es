package com.isamadrid90.fizzbuzz

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class FizzBuzzTranslatorTest {
    private lateinit var counter: Counter
    private lateinit var fizzBuzzTranslator: FizzBuzzTranslator

    @BeforeEach
    internal fun setUp() {
        counter = mockk()
        fizzBuzzTranslator = FizzBuzzTranslator(counter)
    }

    @Test
    fun `should return Fizz when number is multiple of 3`() {
        every { counter.count(any(), any()) } returns IntRange(3, 3)

        val response = fizzBuzzTranslator.execute(3, 3)

        assertEquals(listOf("Fizz"), response)
    }

    @Test
    fun `should return Buzz when number is multiple of 5`() {
        every { counter.count(any(), any()) } returns IntRange(5, 5)

        val response = fizzBuzzTranslator.execute(5, 5)

        assertEquals(listOf("Buzz"), response)
    }

    @Test
    fun `should return FizzBuzz when number is multiple of 3 and 5`() {
        every { counter.count(any(), any()) } returns IntRange(15, 15)

        val response = fizzBuzzTranslator.execute(15, 15)

        assertEquals(listOf("FizzBuzz"), response)
    }
}
