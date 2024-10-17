package com.example.calculatorapp.dependencies_injection

import android.content.Context
import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore.Companion.getStoredCalculationExpression
import com.example.calculatorapp.domains.calculator.CalculationExpression
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking

@Module
@InstallIn(SingletonComponent::class)
class CalculationExpressionModule {
    @Provides
    fun provideCalculationExpression(@ApplicationContext context: Context): CalculationExpression {
        lateinit var storedCalculationExpression: String

        runBlocking {
            storedCalculationExpression = getStoredCalculationExpression(
                context
            )
        }

        return CalculationExpression(storedCalculationExpression)
    }
}