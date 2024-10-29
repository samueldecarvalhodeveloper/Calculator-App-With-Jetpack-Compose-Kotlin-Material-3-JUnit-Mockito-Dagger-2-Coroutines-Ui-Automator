package com.example.calculatorapp.components

import com.example.calculatorapp.domains.calculator.CalculationExpression
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class CalculatorTest {
    companion object {
        private lateinit var calculator: Calculator
        private lateinit var calculationExpressionActiveRecord: CalculationExpressionActiveRecordDecorator

        @BeforeClass
        @JvmStatic
        fun beforeAll() {
            val calculationExpression = CalculationExpression("")
            val calculationExpressionRegister =
                CalculationExpressionRegister(calculationExpression)
            calculationExpressionActiveRecord =
                CalculationExpressionActiveRecordDecorator(calculationExpressionRegister)
            calculator = Calculator(calculationExpressionActiveRecord)
        }
    }

    @Before
    fun beforeEach() {
        calculationExpressionActiveRecord.turnCalculationExpressionEmpty()
    }

    @Test
    fun testIfCalculationExpressionIsGet() {
        val currentCalculationExpression: String = calculationExpressionActiveRecord.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfCharacterIsAddedToCalculationExpression() {
        calculator.addCharacter(CalculatorCharacters.ONE)

        val currentCalculationExpression: String = calculationExpressionActiveRecord.getCalculationExpression()

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression)
    }

    @Test
    fun testIfLastCharacterIsRemovedFromCalculationExpression() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE)
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE)

        calculator.backspace()

        val currentCalculationExpression: String = calculationExpressionActiveRecord.getCalculationExpression()

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression)
    }

    @Test
    fun testIfCalculationExpressionIsCleaned() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE)

        calculator.clean()

        val currentCalculationExpression: String = calculationExpressionActiveRecord.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfCalculationExpressionIsEvaluated() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE)
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ADDITION)
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE)

        calculator.evaluate()

        val currentCalculationExpression: String = calculationExpressionActiveRecord.getCalculationExpression()

        assertEquals(CalculatorCharacters.TWO.value, currentCalculationExpression)
    }
}