package com.example.calculatorapp.unitaries.infrastructure.anticorruption_layer

import android.content.Context
import com.example.calculatorapp.constants.LAST_SESSION_CALCULATION_EXPRESSION_KEY
import com.example.calculatorapp.constants.THEME_KEY
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


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
        val context: Context = mock(Context::class.java)

        @JvmStatic
        @BeforeClass
        fun beforeAll() {
            `when`(context.applicationContext).thenReturn(context)
        }
    }
}