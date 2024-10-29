package com.example.calculatorapp.unitaries.domains.calculator

import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.CalculationExpression
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class CalculationExpressionActiveRecordDecoratorTest {
    companion object {
        private lateinit var calculationExpressionActiveRecordDecorator: CalculationExpressionActiveRecordDecorator
        private lateinit var calculationExpressionRegister: CalculationExpressionRegister

        @BeforeClass
        @JvmStatic
        fun beforeAll() {
            val calculationExpression = CalculationExpression("")
            calculationExpressionRegister = CalculationExpressionRegister(calculationExpression)
            calculationExpressionActiveRecordDecorator =
                CalculationExpressionActiveRecordDecorator(calculationExpressionRegister)
        }
    }

    @Before
    fun beforeEach() {
        calculationExpressionRegister.setCalculationExpression("")
    }

    @Test
    fun testIfMethodGetCalculationExpressionReturnCurrentCalculationExpression() {
        val currentCalculationExpression =
            calculationExpressionActiveRecordDecorator.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodAddCharacterToCalculationExpressionTurnsCalculationToEmptyWhenIsNotValidExpressionExceptionMessage() {
        calculationExpressionRegister.setCalculationExpression(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
        )

        calculationExpressionActiveRecordDecorator.addCharacterToCalculationExpression(
            CalculatorCharacters.ONE
        )

        val currentCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals("", currentCalculationExpression)

        calculationExpressionActiveRecordDecorator.addCharacterToCalculationExpression(
            CalculatorCharacters.ONE
        )

        val updateCalculationExpression = calculationExpressionRegister.getCalculationExpression()

        assertEquals(CalculatorCharacters.ONE.value, updateCalculationExpression)
    }

    @Test
    fun testIfMethodRemoveLastCharacterFromCalculationExpressionTurnsCalculationEmptyIfExpressionIsNotValidExpressionExceptionMessage() {
        calculationExpressionRegister.setCalculationExpression(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
        )

        calculationExpressionActiveRecordDecorator.removeLastCharacterFromCalculationExpression()

        val currentCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodTurnCalculationExpressionEmptyCallsTheSuperTypeMethodAndTurnsExpressionEmpty() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        calculationExpressionActiveRecordDecorator.turnCalculationExpressionEmpty()

        val currentCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodEvaluateCalculationExpressionDoNotDoNothingIfExpressionIsNotValidExpressionExceptionMessage() {
        calculationExpressionRegister.setCalculationExpression(
            NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
        )

        calculationExpressionActiveRecordDecorator.evaluateCalculationExpression()

        val currentCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, currentCalculationExpression)

        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        calculationExpressionActiveRecordDecorator.evaluateCalculationExpression()

        val syntaxCorrectCalculationExpression =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, syntaxCorrectCalculationExpression)
    }
}
