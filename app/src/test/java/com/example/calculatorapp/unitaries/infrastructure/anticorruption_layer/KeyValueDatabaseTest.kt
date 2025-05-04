package com.example.calculatorapp.unitaries.infrastructure.anticorruption_layer

import android.content.Context
import com.example.calculatorapp.constants.LAST_SESSION_CALCULATION_EXPRESSION_KEY
import com.example.calculatorapp.constants.THEME_KEY
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.io.File

class KeyValueDatabaseTest {
    @Test
    fun testIfBooleanValueIsStoredInDatabase() {
        runBlocking {
            KeyValueDatabase.setBooleanValue(THEME_KEY, true, context)

            val retrievedValue = KeyValueDatabase.getBooleanValue(THEME_KEY, context)

            assertTrue(retrievedValue)
        }
    }

    @Test
    fun testIfStringValueIsStoredInDatabase() {
        runBlocking {
            KeyValueDatabase.setStringValue(
                LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                SIMPLE_CALCULATION_EXPRESSION,
                context
            )

            val retrievedValue =
                KeyValueDatabase.getStringValue(LAST_SESSION_CALCULATION_EXPRESSION_KEY, context)

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, retrievedValue)
        }
    }

    companion object {
        private val context = mockk<Context>()
        private val databaseFileName = mockk<File>()

        @JvmStatic
        @BeforeClass
        fun beforeAll() {
            every { databaseFileName.path } returns ""

            every { context.applicationContext } returns context

            every { context.filesDir } returns databaseFileName
        }
    }
}