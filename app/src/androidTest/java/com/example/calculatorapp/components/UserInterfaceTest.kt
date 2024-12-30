package com.example.calculatorapp.components

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.calculatorapp.R
import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import com.example.calculatorapp.constants.ApplicationConstants.Companion.KEY_VALUE_DATABASE_STORING_DELAY
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.domains.calculator.CalculationExpression
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister
import com.example.calculatorapp.domains.calculator.Calculator
import com.example.calculatorapp.domains.calculator.CalculatorCharacters
import com.example.calculatorapp.screens.CalculatorScreen
import com.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import com.example.calculatorapp.view_models.CalculatorViewModel
import com.example.calculatorapp.view_models.ThemeModeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

class UserInterfaceTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun beforeEach() {
        composeTestRule.setContent {
            CalculatorScreen(
                calculatorViewModel = calculationViewModel,
                themeModeViewModel = themeModeViewModel
            )
        }

        calculationViewModel.clean(context)
    }

    @Test
    fun testIfCalculationIsExecutedOnUserInterface() {
        calculationViewModel.addCharacter(
            CalculatorCharacters.ONE,
            context
        )
        calculationViewModel.addCharacter(
            CalculatorCharacters.ADDITION,
            context
        )
        calculationViewModel.addCharacter(
            CalculatorCharacters.ONE,
            context
        )

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value)
            .performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(
                    context
                )

            assertEquals(
                EVALUATED_SIMPLE_CALCULATION_EXPRESSION,
                calculationExpressionLiveData.value
            )
        }
    }

    @Test
    fun testIfToggleThemeIsExecutedOnUserInterface() {
        val actionbarMenuToggleNightModeContentDescription =
            context.getString(R.string.actionbar_menu_toggle_night_mode_content_description)

        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .assertExists()
        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()

        runBlocking(Dispatchers.Main) {
            val nightThemeState = themeModeViewModel.getThemeMode(context)
            val storedNightThemeState = UserInterfaceThemeStore.getNightModeThemeState(context)

            assertTrue(nightThemeState.value!!)
            assertTrue(storedNightThemeState)
        }

        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()
    }

    @Test
    fun testIfUserInterfaceStoresLastSessionCalculationExpression() {
        calculationViewModel.addCharacter(CalculatorCharacters.ONE, context)
        calculationViewModel.addCharacter(CalculatorCharacters.ADDITION, context)
        calculationViewModel.addCharacter(CalculatorCharacters.ONE, context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value)
            .performClick()

        runBlocking {
            delay(KEY_VALUE_DATABASE_STORING_DELAY)

            val storedCalculationExpression =
                CalculationExpressionStore.getStoredCalculationExpression(context)

            assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, storedCalculationExpression)
        }
    }

    @Test
    fun testIfUserInterfaceStoresLastTheme() {
        val actionbarMenuToggleNightModeContentDescription =
            context.getString(R.string.actionbar_menu_toggle_night_mode_content_description)

        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .assertExists()
        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()

        runBlocking {
            val nightThemeState =
                UserInterfaceThemeStore.getNightModeThemeState(context)

            assertTrue(nightThemeState)
        }

        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()
    }

    companion object {
        private lateinit var context: Context

        private lateinit var calculationViewModel: CalculatorViewModel
        private lateinit var themeModeViewModel: ThemeModeViewModel

        @BeforeClass
        @JvmStatic
        fun beforeAll() {
            context = InstrumentationRegistry.getInstrumentation().targetContext

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