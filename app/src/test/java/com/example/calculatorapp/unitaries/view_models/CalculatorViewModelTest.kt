package com.example.calculatorapp.unitaries.view_models

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import com.example.calculatorapp.view_models.CalculatorViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class CalculatorViewModelTest {
    @Before
    fun beforeEach() {
        `when`(calculatorViewModel.getCalculationExpression(context)).thenReturn(
            calculationExpression
        )
        `when`(calculationExpression.value).thenReturn("")
    }

    @Test
    fun testIfMethodGetCalculationExpressionReturnsCalculationExpressionLiveData() {
        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals("", calculationExpressionLiveData.value)
    }

    @Test
    fun testIfMethodAddCharacterAddsChoseCharacterToCalculationExpression() {
        `when`(calculationExpression.value).thenReturn(CalculatorCharacters.ONE.value)

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals(CalculatorCharacters.ONE.value, calculationExpressionLiveData.value)
    }

    @Test
    fun testIfMethodBackspaceRemovesLastCharacterFromCalculationExpression() {
        `when`(calculationExpression.value).thenReturn(CalculatorCharacters.ONE.value)

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)
        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

        calculatorViewModel.backspace(context)

        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals(CalculatorCharacters.ONE.value, calculationExpressionLiveData.value)
    }

    @Test
    fun testIfMethodCleanTurnsCalculationExpressionEmpty() {
        `when`(calculationExpression.value).thenReturn("")

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

        calculatorViewModel.clean(context)

        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals("", calculationExpressionLiveData.value)
    }

    @Test
    fun testIfMethodEvaluateEvaluatesCalculationExpression() {
        `when`(calculationExpression.value).thenReturn(EVALUATED_SIMPLE_CALCULATION_EXPRESSION)

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)
        calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context)
        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

        calculatorViewModel.evaluate(context)

        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, calculationExpressionLiveData.value)
    }

    companion object {
        private lateinit var context: Context
        private lateinit var calculatorViewModel: CalculatorViewModel
        private lateinit var calculationExpression: MutableLiveData<String>

        @JvmStatic
        @BeforeClass
        fun beforeAll() {
            context = mock(Context::class.java)
            calculatorViewModel = mock(CalculatorViewModel::class.java)
            calculationExpression = mock(MutableLiveData::class.java) as MutableLiveData<String>
        }
    }
}