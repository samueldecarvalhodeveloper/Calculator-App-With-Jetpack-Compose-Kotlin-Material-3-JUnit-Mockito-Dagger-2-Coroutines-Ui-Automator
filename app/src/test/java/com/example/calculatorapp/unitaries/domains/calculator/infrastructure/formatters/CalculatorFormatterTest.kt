package com.example.calculatorapp.unitaries.domains.calculator.infrastructure.formatters

import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER
import com.example.calculatorapp.domains.calculator.infrastructure.formatters.CalculatorFormatter.Companion.getCalculationExpressionWithoutLastCharacter
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorFormatterTest {
    @Test
    fun testIfMethodGetCalculationExpressionWithoutLastCharacterReturnExpressionWithoutLastCharacter() {
        val calculationExpressionWithoutLastCharacter: String =
            getCalculationExpressionWithoutLastCharacter(SIMPLE_CALCULATION_EXPRESSION)

        assertEquals(
            SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER,
            calculationExpressionWithoutLastCharacter
        )
    }
}
