package com.example.calculatorapp.domains.calculator.infrastructure.specifications

import com.example.calculatorapp.constants.StringUtilitiesConstants
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE

class CalculatorSpecificationsTest {
    companion object {
        fun isCalculationResultARationalNumber(evaluatedCalculationExpression: Double): Boolean {
            return evaluatedCalculationExpression != evaluatedCalculationExpression.toInt()
                .toDouble()
        }

        fun isCalculationExpressionEmpty(calculationExpression: String): Boolean {
            return calculationExpression == StringUtilitiesConstants.EMPTY_STRING
        }

        fun isCalculationExpressionNotValidExpressionExceptionMessage(calculationExpression: String): Boolean {
            return calculationExpression == NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
        }
    }
}
