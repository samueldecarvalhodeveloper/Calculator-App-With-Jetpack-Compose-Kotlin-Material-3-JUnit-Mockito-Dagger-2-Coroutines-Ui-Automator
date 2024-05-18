package com.example.calculatorapp.unitaries.domains.calculator.infrastructure.specifications

import com.example.calculatorapp.constants.StringUtilitiesConstants.Companion.EMPTY_STRING
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NUMBER_WITHOUT_REST
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NUMBER_WITH_REST
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecificationsTest.Companion.isCalculationExpressionEmpty
import com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecificationsTest.Companion.isCalculationExpressionNotValidExpressionExceptionMessage
import com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecificationsTest.Companion.isCalculationResultARationalNumber
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CalculatorSpecificationsTest {
    @Test
    fun testIfMethodIsCalculationResultARationalNumberReturnsTrueIfNumberIsAFloatingNumber() {
        val rationalNumber = isCalculationResultARationalNumber(NUMBER_WITH_REST)
        val notRationalNumber = isCalculationResultARationalNumber(NUMBER_WITHOUT_REST)

        assertTrue(rationalNumber)
        assertFalse(notRationalNumber)
    }

    @Test
    fun testIfMethodIsCalculationExpressionEmptyReturnsTrueIfCalculationExpressionIsEmpty() {
        val emptyExpression = isCalculationExpressionEmpty(EMPTY_STRING)
        val notEmptyExpression = isCalculationExpressionEmpty(SIMPLE_CALCULATION_EXPRESSION)

        assertTrue(emptyExpression)
        assertFalse(notEmptyExpression)
    }

    @Test
    fun testIfMethodIsCalculationExpressionNotValidExpressionExceptionMessageReturnsTrueIfCalculationExpressionIsNotValidExpressionMessage() {
        val calculationExpressionIsNotValidExpressionMessage =
            isCalculationExpressionNotValidExpressionExceptionMessage(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
            )
        val notValidExpressionMessage =
            isCalculationExpressionNotValidExpressionExceptionMessage(SIMPLE_CALCULATION_EXPRESSION)

        assertTrue(calculationExpressionIsNotValidExpressionMessage)
        assertFalse(notValidExpressionMessage)
    }
}
