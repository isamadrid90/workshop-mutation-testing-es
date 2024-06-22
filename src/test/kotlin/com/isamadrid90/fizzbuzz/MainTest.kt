package com.isamadrid90.fizzbuzz

import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class MainTest {

    @Test
    fun `same first and last`() {
        val printer = mockk<Printer>(relaxUnitFun = true)

        val translator = mockk<FizzBuzzTranslator>()

        every { translator.execute(any(), any()) } returns listOf()

        Main(translator, printer).execute(0, 0)

        verify { printer wasNot Called }
    }
}
