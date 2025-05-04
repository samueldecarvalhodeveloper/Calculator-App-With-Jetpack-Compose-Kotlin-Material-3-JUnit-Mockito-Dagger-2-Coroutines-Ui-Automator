package com.example.calculatorapp.domains.calculator.infrastructure.anticorruption_layer

import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
import com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionRationalNumber
import net.objecthunter.exp4j.ExpressionBuilder

class ExpressionEvaluator {
    companion object {
        fun getEvaluatedCalculationExpression(calculationExpression: String): String {
            try {
                val evaluatedCalculationExpression = ExpressionBuilder(calculationExpression)
                    .build()
                    .evaluate()

                return if (isCalculationExpressionRationalNumber(
                        evaluatedCalculationExpression
                    )
                )
                    evaluatedCalculationExpression.toString() else
                    evaluatedCalculationExpression.toInt()
                        .toString()
            } catch (exception: Exception) {
                return NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
            }
        }
    }
}