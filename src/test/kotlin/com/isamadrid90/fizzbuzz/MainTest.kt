package com.isamadrid90.fizzbuzz

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MainTest {

    private lateinit var counter: Counter
    private lateinit var fizzBuzzTranslator: FizzBuzzTranslator
    private lateinit var printer: Printer
    private lateinit var main: Main

    @BeforeEach
    fun setUp() {
        counter = mockk()
        printer = mockk(relaxUnitFun = true)
        fizzBuzzTranslator = FizzBuzzTranslator(counter)
        main = Main(fizzBuzzTranslator, printer)
    }

    @Test
    fun `should print all numbers between 1 and 100`() {
        val range = 1..100
        every { counter.count(any(), any()) } returns range

        main.execute(range.first, range.last)

        verify(exactly = range.count()) { printer.execute(any()) }
    }
}
