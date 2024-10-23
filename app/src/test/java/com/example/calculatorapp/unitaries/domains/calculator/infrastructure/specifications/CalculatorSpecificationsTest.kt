package com.example.calculatorapp.unitaries.domains.calculator.infrastructure.specifications

import com.example.calculatorapp.constants.domains.CalculatorConstants
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NUMBER_WITHOUT_REST
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NUMBER_WITH_REST
import com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionEmpty
import com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionNotValidExpressionExceptionMessage
import com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionRationalNumber
import org.junit.Assert
import org.junit.Test

class CalculatorSpecificationsTest {
    @Test
    fun testIfMethodIsCalculationExpressionARationalNumberReturnsTrueIfNumberIsAFloatingNumber() {
        val rationalNumber: Boolean = isCalculationExpressionRationalNumber(NUMBER_WITH_REST)
        val notRationalNumber: Boolean = isCalculationExpressionRationalNumber(NUMBER_WITHOUT_REST)

        Assert.assertTrue(rationalNumber)
        Assert.assertFalse(notRationalNumber)
    }

    @Test
    fun testIfMethodIsCalculationExpressionEmptyReturnsTrueIfCalculationExpressionIsEmpty() {
        val emptyExpression: Boolean = isCalculationExpressionEmpty("")
        val notEmptyExpression: Boolean =
            isCalculationExpressionEmpty(CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION)

        Assert.assertTrue(emptyExpression)
        Assert.assertFalse(notEmptyExpression)
    }

    @Test
    fun testIfMethodIsCalculationExpressionNotValidExpressionExceptionMessageReturnsTrueIfCalculationExpressionIsNotValidExpressionMessage() {
        val calculationExpressionIsNotValidExpressionMessage: Boolean =
            isCalculationExpressionNotValidExpressionExceptionMessage(
                CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
            )
        val notValidExpressionMessage: Boolean =
            isCalculationExpressionNotValidExpressionExceptionMessage(CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION)

        Assert.assertTrue(calculationExpressionIsNotValidExpressionMessage)
        Assert.assertFalse(notValidExpressionMessage)
    }
}