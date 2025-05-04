package com.example.calculatorapp.unitaries.view_models

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import com.example.calculatorapp.view_models.CalculatorViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class CalculatorViewModelTest {
    @Before
    fun beforeEach() {
        every { calculatorViewModel.getCalculationExpression(context) } returns calculationExpression

        every { calculationExpression.value } returns ""
    }

    @Test
    fun testIfMethodGetCalculationExpressionReturnsCalculationExpressionLiveData() {
        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals("", calculationExpressionLiveData.value)
    }

    @Test
    fun testIfMethodAddCharacterAddsChoseCharacterToCalculationExpression() {
        every { calculationExpression.value } returns CalculatorCharacters.ONE.value

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals(CalculatorCharacters.ONE.value, calculationExpressionLiveData.value)
    }

    @Test
    fun testIfMethodBackspaceRemovesLastCharacterFromCalculationExpression() {
        every { calculationExpression.value } returns CalculatorCharacters.ONE.value

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)
        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

        calculatorViewModel.backspace(context)

        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals(CalculatorCharacters.ONE.value, calculationExpressionLiveData.value)
    }

    @Test
    fun testIfMethodCleanTurnsCalculationExpressionEmpty() {
        every { calculationExpression.value } returns ""

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

        calculatorViewModel.clean(context)

        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals("", calculationExpressionLiveData.value)
    }

    @Test
    fun testIfMethodEvaluateEvaluatesCalculationExpression() {
        every { calculationExpression.value } returns EVALUATED_SIMPLE_CALCULATION_EXPRESSION

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)
        calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context)
        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context)

        calculatorViewModel.evaluate(context)

        val calculationExpressionLiveData = calculatorViewModel.getCalculationExpression(context)

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, calculationExpressionLiveData.value)
    }

    companion object {
        private val context = mockk<Context>()
        private val calculatorViewModel = mockk<CalculatorViewModel>(relaxed = true)
        private val calculationExpression = mockk<MutableLiveData<String>>()
    }
}