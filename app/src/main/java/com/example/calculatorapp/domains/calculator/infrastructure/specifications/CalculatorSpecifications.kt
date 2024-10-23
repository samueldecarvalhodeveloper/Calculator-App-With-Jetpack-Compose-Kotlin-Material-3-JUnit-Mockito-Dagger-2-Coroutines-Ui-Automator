package com.example.calculatorapp.domains.calculator.infrastructure.specifications

import com.example.calculatorapp.constants.domains.CalculatorConstants

object CalculatorSpecifications {
    fun isCalculationExpressionRationalNumber(evaluatedCalculationExpression: Double): Boolean {
        return evaluatedCalculationExpression != evaluatedCalculationExpression.toInt().toDouble()
    }

    fun isCalculationExpressionEmpty(calculationExpression: String): Boolean {
        return calculationExpression == ""
    }

    fun isCalculationExpressionNotValidExpressionExceptionMessage(calculationExpression: String): Boolean {
        return calculationExpression == CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
    }
}