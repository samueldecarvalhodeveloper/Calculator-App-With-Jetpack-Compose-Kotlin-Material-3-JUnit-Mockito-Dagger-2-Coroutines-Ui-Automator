package com.example.calculatorapp.unitaries.application

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.calculatorapp.R
import com.example.calculatorapp.application.Application
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.CalculationExpression
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import com.example.calculatorapp.view_models.CalculatorViewModel
import com.example.calculatorapp.view_models.ThemeModeViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

class ApplicationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun beforeEach() {
        composeTestRule.setContent {
            Application(calculationViewModel, themeModeViewModel)
        }
    }

    @Test
    fun testIfApplicationComponentsSetsUpAllAppNeededDependencies() {
        val actionbarMenuToggleNightModeContentDescription =
            context.getString(R.string.actionbar_menu_toggle_night_mode_content_description)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).performClick()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ADDITION.value)
            .performClick()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).performClick()

        composeTestRule.onNodeWithText(SIMPLE_CALCULATION_EXPRESSION).assertExists()

        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()

        runTest {
            val nightThemeState = UserInterfaceThemeStore.getNightModeThemeState(context)

            assertTrue(nightThemeState)
        }
    }

    companion object {
        private lateinit var calculationViewModel: CalculatorViewModel
        private lateinit var themeModeViewModel: ThemeModeViewModel

        @JvmStatic
        @BeforeClass
        fun beforeAll() {
            val calculationExpression = CalculationExpression("")
            val calculationExpressionRegister = CalculationExpressionRegister(calculationExpression)
            val calculationExpressionActiveRecord =
                CalculationExpressionActiveRecordDecorator(calculationExpressionRegister)
            val calculator = Calculator(calculationExpressionActiveRecord)
            calculationViewModel = CalculatorViewModel(calculator)
            themeModeViewModel = ThemeModeViewModel()
        }
    }
}