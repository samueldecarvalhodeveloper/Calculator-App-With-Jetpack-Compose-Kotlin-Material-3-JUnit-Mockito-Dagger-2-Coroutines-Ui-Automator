package com.example.calculatorapp.components

import com.example.calculatorapp.constants.StringUtilitiesConstants.Companion.EMPTY_STRING
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.CalculationExpression
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private lateinit var calculator: Calculator

    @Before
    fun beforeEach() {
        val calculationExpression = CalculationExpression(EMPTY_STRING)
        val calculationExpressionRegister = CalculationExpressionRegister(calculationExpression)
        val calculationExpressionActiveRecord =
            CalculationExpressionActiveRecordDecorator(calculationExpressionRegister)
        calculator = Calculator(calculationExpressionActiveRecord)
    }

    @Test
    fun testIfComponentHandlesDataInputAndOutputsScenario() {
        val initialCalculationExpression = calculator.getCalculationExpression()

        assertEquals(EMPTY_STRING, initialCalculationExpression)

        calculator.addCharacter(CalculatorCharacters.ONE)
        calculator.addCharacter(CalculatorCharacters.ADDITION)
        calculator.addCharacter(CalculatorCharacters.ONE)

        calculator.backspace()

        calculator.addCharacter(CalculatorCharacters.ONE)

        calculator.evaluate()

        val currentCalculationExpression = calculator.getCalculationExpression()

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression)

        calculator.clean()

        val finalCalculationExpression = calculator.getCalculationExpression()

        assertEquals(EMPTY_STRING, finalCalculationExpression)
    }
}