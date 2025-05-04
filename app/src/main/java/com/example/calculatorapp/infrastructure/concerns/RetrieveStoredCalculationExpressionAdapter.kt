package com.example.calculatorapp.infrastructure.concerns

import android.content.Context
import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import kotlinx.coroutines.runBlocking

class RetrieveStoredCalculationExpressionAdapter {
    companion object {
        fun getStoredCalculationExpression(context: Context): String {
            lateinit var storedCalculationExpression: String

            runBlocking {
                storedCalculationExpression =
                    CalculationExpressionStore.getStoredCalculationExpression(context)
            }

            return storedCalculationExpression
        }
    }
}