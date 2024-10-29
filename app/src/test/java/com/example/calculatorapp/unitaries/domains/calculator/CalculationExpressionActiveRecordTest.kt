package com.example.calculatorapp.unitaries.domains.calculator

import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER
import com.example.calculatorapp.domains.calculator.CalculationExpression
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecord
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class CalculationExpressionActiveRecordTest {
    companion object {
        private lateinit var calculationExpressionActiveRecord: CalculationExpressionActiveRecord
        private lateinit var calculationExpressionRegister: CalculationExpressionRegister

        @BeforeClass
        @JvmStatic
        fun beforeAll() {
            val calculationExpression = CalculationExpression("")
            calculationExpressionRegister = CalculationExpressionRegister(calculationExpression)
            calculationExpressionActiveRecord =
                CalculationExpressionActiveRecord(calculationExpressionRegister)
        }

    }

    @Before
    fun beforeEach() {
        calculationExpressionRegister.setCalculationExpression("")
    }

    @Test
    fun testIfMethodGetCalculationExpressionReturnCurrentCalculationExpression() {
        val currentCalculationExpression =
            calculationExpressionActiveRecord.getCalculationExpression()

        assertEquals("", currentCalculationExpression)
    }

    @Test
    fun testIfMethodAddCharacterToCalculatorExpressionAddChoseCharacterToCalculationExpression() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE)

        val currentCalculationExpression: String =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression)
    }

    @Test
    fun testIfMethodRemoveLastCharacterFromCalculationExpressionRemovesLastCharacterFromExpression() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        calculationExpressionActiveRecord.removeLastCharacterFromCalculationExpression()

        val currentCalculationExpression: String =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(
            SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER,
            currentCalculationExpression
        )
    }

    @Test
    fun testIfMethodTurnCalculationExpressionEmptyMakesTheCalculationExpressionIntoEmptyString() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        val currentCalculationExpression: String =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression)

        calculationExpressionActiveRecord.turnCalculationExpressionEmpty()

        val updatedCalculationExpression: String =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals("", updatedCalculationExpression)
    }

    @Test
    fun testIfMethodEvaluateCalculationExpressionTurnsTheCalculationExpressionIntoEvaluatedValue() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION)

        calculationExpressionActiveRecord.evaluateCalculationExpression()

        val currentCalculationExpression: String =
            calculationExpressionRegister.getCalculationExpression()

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression)
    }
}
