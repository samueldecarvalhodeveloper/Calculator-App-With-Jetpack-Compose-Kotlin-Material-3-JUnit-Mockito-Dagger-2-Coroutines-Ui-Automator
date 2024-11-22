package com.example.calculatorapp.infrastructure.concerns

import android.content.Context
import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import com.example.calculatorapp.constants.THEME_KEY
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import com.example.calculatorapp.unitaries.infrastructure.anticorruption_layer.KeyValueDatabaseTest.Companion.context
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito

class RetrieveStoredCalculationExpressionAdapterTest {
    @Test
    fun testIfClassHandleCalculationExpressionStoringOnKeyValueDatabase() {
        runBlocking {
            CalculationExpressionStore.setStoredCalculationExpression(
                SIMPLE_CALCULATION_EXPRESSION,
                context
            )

        }

        val retrievedCalculationExpression =
            RetrieveStoredCalculationExpressionAdapter.getStoredCalculationExpression(context)

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, retrievedCalculationExpression)
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