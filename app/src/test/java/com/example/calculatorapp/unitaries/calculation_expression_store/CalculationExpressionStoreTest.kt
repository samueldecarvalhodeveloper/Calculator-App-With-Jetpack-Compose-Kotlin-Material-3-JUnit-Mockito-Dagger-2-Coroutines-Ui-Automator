package com.example.calculatorapp.unitaries.calculation_expression_store

import android.content.Context
import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.io.File

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
