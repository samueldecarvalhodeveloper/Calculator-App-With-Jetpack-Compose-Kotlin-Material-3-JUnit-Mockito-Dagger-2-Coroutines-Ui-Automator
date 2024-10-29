package com.example.calculatorapp.unitaries.domains.calculator

import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.CalculationExpression
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test


class CalculationExpressionRegisterTest {
    companion object {
        private lateinit var calculationExpression: CalculationExpression
        private lateinit var calculationExpressionRegister: CalculationExpressionRegister

        @BeforeClass
        @JvmStatic
        fun beforeAll() {
            calculationExpression = CalculationExpression("")
            calculationExpressionRegister = CalculationExpressionRegister(calculationExpression)
        }
    }

    @Before
    fun beforeEach() {
        calculationExpression.calculationExpression = ""
    }

    @Test
    fun testIfMethodGetCalculationExpressionReturnsTheCurrentCalculationExpression() {
        val currentCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodSetCalculationExpressionReplacesTheCalculationExpression() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        val currentCalculationExpression: String = calculationExpression.calculationExpression

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression)
    }

    @Test
    fun testIfMethodAddCharacterToCalculationExpressionAddsChoseCharacterToCalculationExpression() {
        calculationExpressionRegister.addCharacterToCalculationExpression(CalculatorCharacters.ONE)

        val currentCalculationExpression: String = calculationExpression.calculationExpression

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression)
    }
}
