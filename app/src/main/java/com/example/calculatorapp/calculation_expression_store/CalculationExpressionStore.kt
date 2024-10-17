package com.example.calculatorapp.calculation_expression_store

import android.content.Context
import com.example.calculatorapp.constants.LAST_SESSION_CALCULATION_EXPRESSION_KEY
import com.example.calculatorapp.constants.StringUtilitiesConstants.Companion.EMPTY_STRING
import com.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase
import com.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException

class CalculationExpressionStore {
    companion object {
        suspend fun getStoredCalculationExpression(context: Context): String {
            try {
                return KeyValueDatabase.getStringValue(
                    LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                    context
                )
            } catch (exception: NotExistingKeyException) {
                KeyValueDatabase.setStringValue(
                    LAST_SESSION_CALCULATION_EXPRESSION_KEY, EMPTY_STRING,
                    context
                )
                return EMPTY_STRING
            }
        }

        suspend fun setStoredCalculationExpression(
            newCalculationExpression: String,
            context: Context
        ) {
            KeyValueDatabase.setStringValue(
                LAST_SESSION_CALCULATION_EXPRESSION_KEY,
                newCalculationExpression, context
            )
        }
    }
}
