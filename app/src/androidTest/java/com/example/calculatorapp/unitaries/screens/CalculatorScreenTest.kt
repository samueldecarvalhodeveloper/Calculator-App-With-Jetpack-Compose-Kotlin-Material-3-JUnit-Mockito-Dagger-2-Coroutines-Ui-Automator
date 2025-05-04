package com.example.calculatorapp.unitaries.screens

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.calculatorapp.R
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
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

class CalculatorScreenTest {
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
    fun testIfAllNumericalCharactersAreSetAndDispatchesAddCharacterWithItsCharacter() {
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ZERO.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.TWO.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.THREE.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.FOUR.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.FIVE.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SIX.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SEVEN.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EIGHT.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.NINE.value).assertExists()

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ZERO.value).performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.ZERO.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.ONE.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.TWO.value).performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.TWO.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.THREE.value).performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.THREE.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.FOUR.value).performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.FOUR.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.FIVE.value).performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.FIVE.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SIX.value).performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.SIX.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SEVEN.value).performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.SEVEN.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EIGHT.value).performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.EIGHT.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.NINE.value).performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.NINE.value,
                calculationExpressionLiveData.value
            )
        }
    }

    @Test
    fun testIfAllSymbolsCharactersIsSetAndDispatchesAddCharacterWithItsCharacter() {
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.POINT.value).assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.POINT.value).performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.POINT.value,
                calculationExpressionLiveData.value
            )
        }
    }

    @Test
    fun testIfAllOperatorsCharactersAreSetAndDispatchesAddCharacterWithItsCharacter() {
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ADDITION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ADDITION.value)
            .performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.ADDITION.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SUBTRACTION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.SUBTRACTION.value)
            .performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.SUBTRACTION.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.MULTIPLICATION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.MULTIPLICATION.value)
            .performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.MULTIPLICATION.value,
                calculationExpressionLiveData.value
            )
        }

        calculationViewModel.clean(context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.DIVISION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.DIVISION.value)
            .performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                UserInterfaceCalculatorCharacters.DIVISION.value,
                calculationExpressionLiveData.value
            )
        }
    }

    @Test
    fun testIfAllClearCharactersIsSetAndDispatchesCleanViewModelMethod() {
        calculationViewModel.addCharacter(CalculatorCharacters.ONE, context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.CLEAN.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.CLEAN.value)
            .performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                "",
                calculationExpressionLiveData.value
            )
        }
    }

    @Test
    fun testIfAllEvaluateCharactersIsSetAndDispatchesEvaluateViewModelMethod() {
        calculationViewModel.addCharacter(CalculatorCharacters.ONE, context)
        calculationViewModel.addCharacter(CalculatorCharacters.ADDITION, context)
        calculationViewModel.addCharacter(CalculatorCharacters.ONE, context)

        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value)
            .assertExists()
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.EVALUATION.value)
            .performClick()

        runBlocking(Dispatchers.Main) {
            val calculationExpressionLiveData =
                calculationViewModel.getCalculationExpression(context)

            assertEquals(
                EVALUATED_SIMPLE_CALCULATION_EXPRESSION,
                calculationExpressionLiveData.value
            )
        }
    }

    @Test
    fun testIfActionBarActionButtonTogglesThemeMode() {
        val actionbarMenuToggleNightModeContentDescription =
            context.getString(R.string.actionbar_menu_toggle_night_mode_content_description)

        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .assertExists()
        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()

        runBlocking {
            val nightThemeState = UserInterfaceThemeStore.getNightModeThemeState(context)

            assertTrue(nightThemeState)
        }
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