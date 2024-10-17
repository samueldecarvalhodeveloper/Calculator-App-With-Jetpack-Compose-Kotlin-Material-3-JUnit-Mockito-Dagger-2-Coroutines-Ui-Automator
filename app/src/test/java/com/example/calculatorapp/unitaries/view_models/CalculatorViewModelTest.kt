package com.example.calculatorapp.unitaries.view_models

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.calculatorapp.constants.StringUtilitiesConstants.Companion.EMPTY_STRING
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import com.example.calculatorapp.view_models.CalculatorViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class CalculatorViewModelTest {
    val context = mock(Context::class.java)
    val calculatorViewModel = mock(CalculatorViewModel::class.java)
    val calculationExpression = mock(MutableLiveData::class.java) as MutableLiveData<String>

    @Before
    fun beforeEach() {
        `when`(calculatorViewModel.getCalculationExpression(context)).thenReturn(
            calculationExpression
        )
        `when`(calculationExpression.value).thenReturn(EMPTY_STRING)
    }

    @Test
    fun testIfMethodGetCalculationExpressionReturnsCalculationExpressionLiveData() {
        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals(EMPTY_STRING, calculationExpressionLiveData.value)
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
        `when`(calculationExpression.value).thenReturn(EMPTY_STRING)

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

        calculatorViewModel.clean(context)

        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals(EMPTY_STRING, calculationExpressionLiveData.value)
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
}