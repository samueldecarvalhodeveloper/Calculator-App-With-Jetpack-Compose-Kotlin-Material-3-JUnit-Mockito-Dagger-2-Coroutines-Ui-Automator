package com.example.calculatorapp.unitaries.domains.calculator.infrastructure.anticorruption_layer

import com.example.calculatorapp.constants.domains.CalculatorConstants
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NOT_VALID_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.infrastructure.anticorruption_layer.ExpressionEvaluator.Companion.getEvaluatedCalculationExpression
import org.junit.Assert
import org.junit.Test

class ExpressionEvaluatorTest {
    @Test
    fun testIfMethodGetEvaluatedCalculationExpressionReturnsEvaluatedExpression() {
        val evaluatedExpression: String =
            getEvaluatedCalculationExpression(CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION)

        Assert.assertEquals(
            CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION,
            evaluatedExpression
        )
    }

    @Test
    fun testIfMethodGetEvaluatedCalculationExpressionReturnsNotValidExpressionIfExpressionIsNotValid() {
        val evaluatedExpression: String =
            getEvaluatedCalculationExpression(NOT_VALID_CALCULATION_EXPRESSION)

        Assert.assertEquals(
            CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE,
            evaluatedExpression
        )
    }
}