package com.example.calculatorapp.application

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import com.example.calculatorapp.screens.CalculatorScreen
import com.example.calculatorapp.theme.Theme
import com.example.calculatorapp.view_models.CalculatorViewModel
import com.example.calculatorapp.view_models.ThemeModeViewModel

@Composable
fun Application(
    calculatorViewModel: CalculatorViewModel,
    themeModeViewModel: ThemeModeViewModel
) {
    val context = LocalContext.current

    val themeMode = themeModeViewModel.getThemeMode(context = context)
        .observeAsState()
        .value as Boolean

    Theme(isThemeDark = themeMode) {
        CalculatorScreen(calculatorViewModel, themeModeViewModel)
    }
}
