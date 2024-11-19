package com.example.calculatorapp.dependency_injection

import com.example.calculatorapp.domains.calculator.CalculationExpression
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecord
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.view_models.CalculatorViewModel
import com.example.calculatorapp.view_models.ThemeModeViewModel
import org.koin.dsl.module

val applicationModule = module {
    single { CalculationExpression(get()) }

    single { CalculationExpressionRegister(get()) }

    single<CalculationExpressionActiveRecord> {
        CalculationExpressionActiveRecordDecorator(get())
    }

    single { Calculator(get()) }

    single { CalculatorViewModel(get()) }

    single { ThemeModeViewModel() }
}