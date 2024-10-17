package com.example.calculatorapp.domains.calculator.infrastructure.formatters

import com.example.calculatorapp.constants.StringUtilitiesConstants.Companion.STRING_FIRST_INDEX
import com.example.calculatorapp.constants.StringUtilitiesConstants.Companion.STRING_LAST_INDEX

class CalculatorFormatter {
    companion object {
        fun getCalculationExpressionWithoutLastCharacter(calculationExpression: String): String {
            return calculationExpression.substring(
                STRING_FIRST_INDEX,
                STRING_LAST_INDEX(calculationExpression)
            )
        }
    }
}