package com.example.calculatorapp.unitaries.domains.calculator.infrastructure.anticorruption_layer

import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NOT_VALID_CALCULATION_EXPRESSION
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.infrastructure.anticorruption_layer.ExpressionEvaluater.Companion.getEvaluatedCalculationExpression
import org.junit.Assert.assertEquals
import org.junit.Test

class ExpressionEvaluaterTest {
    @Test
    fun testIfMethodGetEvaluatedCalculationExpressionReturnsEvaluatedExpression() {
        val evaluatedExpression = getEvaluatedCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, evaluatedExpression)
    }

    @Test
    fun testIfMethodGetEvaluatedCalculationExpressionReturnsNotValidExpressionIfExpressionIsNotValid() {
        val evaluatedExpression =
            getEvaluatedCalculationExpression(NOT_VALID_CALCULATION_EXPRESSION)

        assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, evaluatedExpression)
    }
}