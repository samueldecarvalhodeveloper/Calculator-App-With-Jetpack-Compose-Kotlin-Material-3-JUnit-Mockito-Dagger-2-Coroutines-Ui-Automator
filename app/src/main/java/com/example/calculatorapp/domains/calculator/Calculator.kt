package com.example.calculatorapp.domains.calculator

import com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionEmpty

class Calculator(private val calculatorExpressionActiveRecord: CalculationExpressionActiveRecord) {
    fun getCalculationExpression(): String {
        return calculatorExpressionActiveRecord.getCalculationExpression()
    }

    fun addCharacter(calculatorCharacters: CalculatorCharacters) {
        calculatorExpressionActiveRecord.addCharacterToCalculationExpression(calculatorCharacters)
    }

    fun backspace() {
        val currentCalculationExpression =
            calculatorExpressionActiveRecord.getCalculationExpression()

        if (isCalculationExpressionEmpty(
                currentCalculationExpression
            )
        ) return

        calculatorExpressionActiveRecord.removeLastCharacterFromCalculationExpression()
    }

    fun clean() {
        val currentCalculationExpression =
            calculatorExpressionActiveRecord.getCalculationExpression()

        if (isCalculationExpressionEmpty(
                currentCalculationExpression
            )
        ) return

        calculatorExpressionActiveRecord.turnCalculationExpressionEmpty()
    }

    fun evaluate() {
        val currentCalculationExpression =
            calculatorExpressionActiveRecord.getCalculationExpression()

        if (isCalculationExpressionEmpty(
                currentCalculationExpression
            )
        ) return

        calculatorExpressionActiveRecord.evaluateCalculationExpression()
    }
}
