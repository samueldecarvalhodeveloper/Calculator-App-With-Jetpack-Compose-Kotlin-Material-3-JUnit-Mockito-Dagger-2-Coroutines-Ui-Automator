package com.example.calculatorapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.calculatorapp.application.Application
import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import com.example.calculatorapp.infrastructure.concerns.RetrieveStoredCalculationExpressionAdapter
import com.example.calculatorapp.view_models.CalculatorViewModel
import com.example.calculatorapp.view_models.ThemeModeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val lastSessionCalculationExpression =
            RetrieveStoredCalculationExpressionAdapter.getStoredCalculationExpression(baseContext)

        val calculatorViewModel: CalculatorViewModel
                by viewModel { parametersOf(lastSessionCalculationExpression) }
        val themeModeViewModel: ThemeModeViewModel by viewModel()

        setContent {
            Application(calculatorViewModel, themeModeViewModel)
        }
    }
}