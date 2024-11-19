package com.example.calculatorapp.domains.calculator

class CalculationExpressionRegister(
    private val calculationExpression: CalculationExpression
) {
    fun getCalculationExpression(): String {
        return calculationExpression.calculationExpression
    }

    fun setCalculationExpression(newExpression: String) {
        calculationExpression.calculationExpression = newExpression
    }

    fun addCharacterToCalculationExpression(calculatorCharacters: CalculatorCharacters) {
        val currentCalculationExpression = calculationExpression.calculationExpression
        val calculationExpressionWithNewCharacter =
            currentCalculationExpression + calculatorCharacters.value

        calculationExpression.calculationExpression = calculationExpressionWithNewCharacter
    }
}
