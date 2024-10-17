package com.example.calculatorapp.unitaries.calculation_expression_store

import android.content.Context
import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito

class CalculationExpressionStoreTest {
    @Test
    fun testIfClassHandleCalculationExpressionStoringOnKeyValueDatabase() {
        runBlocking {
            CalculationExpressionStore.setStoredCalculationExpression(
                SIMPLE_CALCULATION_EXPRESSION,
                context
            )

            val retrievedCalculationExpression =
                CalculationExpressionStore.getStoredCalculationExpression(context)

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, retrievedCalculationExpression)
        }
    }

    companion object {
        val context: Context = Mockito.mock(Context::class.java)

        @JvmStatic
        @BeforeClass
        fun beforeAll() {
            Mockito.`when`(context.applicationContext).thenReturn(context)
        }
    }
}
