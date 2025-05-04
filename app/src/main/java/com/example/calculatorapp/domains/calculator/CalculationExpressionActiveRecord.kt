package com.example.calculatorapp.domains.calculator

import com.example.calculatorapp.domains.calculator.infrastructure.anticorruption_layer.ExpressionEvaluator.Companion.getEvaluatedCalculationExpression
import com.example.calculatorapp.domains.calculator.infrastructure.formatters.CalculatorFormatter.Companion.getCalculationExpressionWithoutLastCharacter

open class CalculationExpressionActiveRecord(private val calculationExpressionRegister: CalculationExpressionRegister) {
    open fun getCalculationExpression(): String {
        return calculationExpressionRegister.getCalculationExpression()
    }

    open fun addCharacterToCalculationExpression(character: CalculatorCharacters) {
        calculationExpressionRegister.addCharacterToCalculationExpression(character)
    }

    open fun removeLastCharacterFromCalculationExpression() {
        val currentCalculationExpression = calculationExpressionRegister.getCalculationExpression()
        val currentCalculationExpressionWithoutLastCharacter =
            getCalculationExpressionWithoutLastCharacter(currentCalculationExpression)

        calculationExpressionRegister.setCalculationExpression(
            currentCalculationExpressionWithoutLastCharacter
        )
    }

    open fun turnCalculationExpressionEmpty() {
        calculationExpressionRegister.setCalculationExpression("")
    }

    open fun evaluateCalculationExpression() {
        val currentCalculationExpression = calculationExpressionRegister.getCalculationExpression()
        val evaluatedCalculationExpression =
            getEvaluatedCalculationExpression(currentCalculationExpression)

        calculationExpressionRegister.setCalculationExpression(evaluatedCalculationExpression)
    }
}
