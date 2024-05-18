package com.example.calculatorapp.unitaries.domains.calculator

import com.example.calculatorapp.constants.StringUtilitiesConstants.Companion.EMPTY_STRING
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.CalculationExpression
import org.junit.Assert.assertEquals
import org.junit.Test


class CalculationExpressionTest {
    @Test
    fun testIfClassRepresentsHowCalculationExpressionShouldBeUsedOnClient() {
        val calculationExpression = CalculationExpression(EMPTY_STRING)

        val currentCalculationExpression = calculationExpression.calculationExpression

        assertEquals(EMPTY_STRING, currentCalculationExpression)

        calculationExpression.calculationExpression = SIMPLE_CALCULATION_EXPRESSION

        val updateCalculationExpression = calculationExpression.calculationExpression

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, updateCalculationExpression)
    }
}
