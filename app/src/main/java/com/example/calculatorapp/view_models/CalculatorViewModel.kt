package com.example.calculatorapp.view_models

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculatorapp.R
import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore.Companion.setStoredCalculationExpression
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionNotValidExpressionExceptionMessage
import kotlinx.coroutines.launch

open class CalculatorViewModel(private val calculator: Calculator) : ViewModel() {
    private val calculationExpression: MutableLiveData<String>

    init {
        val initialExpression = calculator.getCalculationExpression()

        calculationExpression = MutableLiveData(initialExpression)
    }

    open fun getCalculationExpression(context: Context): MutableLiveData<String> {
        val currentCalculationExpression = calculator.getCalculationExpression()

        calculationExpression.value = if (isCalculationExpressionNotValidExpressionExceptionMessage(
                currentCalculationExpression
            )
        ) context.getString(R.string.not_valid_expression_message) else currentCalculationExpression

        return calculationExpression
    }

    open fun addCharacter(calculatorCharacters: CalculatorCharacters, context: Context) {
        viewModelScope.launch {
            calculator.addCharacter(calculatorCharacters)

            val currentCalculationExpression = calculator.getCalculationExpression()

            calculationExpression.value = currentCalculationExpression

            setStoredCalculationExpression(currentCalculationExpression, context)
        }
    }

    open fun backspace(context: Context) {
        viewModelScope.launch {
            calculator.backspace()

            val currentCalculationExpression = calculator.getCalculationExpression()

            calculationExpression.value = currentCalculationExpression

            setStoredCalculationExpression(currentCalculationExpression, context)
        }
    }

    open fun clean(context: Context) {
        viewModelScope.launch {
            calculator.clean()

            val currentCalculationExpression = calculator.getCalculationExpression()

            calculationExpression.value = currentCalculationExpression
            
            setStoredCalculationExpression(currentCalculationExpression, context)
        }
    }

    open fun evaluate(context: Context) {
        viewModelScope.launch {
            calculator.evaluate()

            val currentCalculationExpression = calculator.getCalculationExpression()

            calculationExpression.value =
                if (isCalculationExpressionNotValidExpressionExceptionMessage(
                        currentCalculationExpression
                    )
                ) context.getString(R.string.not_valid_expression_message) else currentCalculationExpression

            setStoredCalculationExpression(currentCalculationExpression, context)
        }
    }
}