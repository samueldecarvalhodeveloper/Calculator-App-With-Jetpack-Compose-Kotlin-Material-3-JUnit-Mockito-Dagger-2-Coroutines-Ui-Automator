package com.example.calculatorapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.calculatorapp.application.Application
import com.example.calculatorapp.view_models.CalculatorViewModel
import com.example.calculatorapp.view_models.ThemeModeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        enableEdgeToEdge()

        val calculatorViewModel =
            ViewModelProvider(this)[CalculatorViewModel::class.java]
        val themeModeViewModel =
            ViewModelProvider(this)[ThemeModeViewModel::class.java]

        setContent {
            Application(calculatorViewModel, themeModeViewModel)
        }
    }
}