package com.example.calculatorapp.domains.calculator

import com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionEmpty
import com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionNotValidExpressionExceptionMessage

class CalculationExpressionActiveRecordDecorator(calculationExpressionRegister: CalculationExpressionRegister?) :
    CalculationExpressionActiveRecord(
        calculationExpressionRegister!!
    ) {
    override fun addCharacterToCalculationExpression(character: CalculatorCharacters) {
        val currentCalculationExpression = super.getCalculationExpression()

        if (isCalculationExpressionNotValidExpressionExceptionMessage(
                currentCalculationExpression
            )
        ) {
            super.turnCalculationExpressionEmpty()
        } else {
            super.addCharacterToCalculationExpression(character)
        }
    }

    override fun removeLastCharacterFromCalculationExpression() {
        val currentCalculationExpression = super.getCalculationExpression()

        if (isCalculationExpressionNotValidExpressionExceptionMessage(
                currentCalculationExpression
            )
        ) {
            super.turnCalculationExpressionEmpty()
        } else {
            super.removeLastCharacterFromCalculationExpression()
        }
    }

    override fun evaluateCalculationExpression() {
        val currentCalculationExpression = super.getCalculationExpression()

        if (isCalculationExpressionNotValidExpressionExceptionMessage(
                currentCalculationExpression
            ) ||
            isCalculationExpressionEmpty(currentCalculationExpression)
        ) return

        super.evaluateCalculationExpression()
    }
}
