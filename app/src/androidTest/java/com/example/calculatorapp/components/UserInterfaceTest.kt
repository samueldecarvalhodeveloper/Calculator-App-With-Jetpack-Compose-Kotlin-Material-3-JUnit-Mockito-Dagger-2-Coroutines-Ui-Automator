package com.example.calculatorapp.components

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import com.example.calculatorapp.R
import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import com.example.calculatorapp.constants.ApplicationConstants.Companion.KEY_VALUE_DATABASE_STORING_DELAY
import com.example.calculatorapp.constants.ApplicationConstants.Companion.LAUNCH_TIMEOUT
import com.example.calculatorapp.constants.domains.CalculatorConstants.Companion.EVALUATED_SIMPLE_CALCULATION_EXPRESSION
import com.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class UserInterfaceTest {
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun beforeEach() {
        device.pressHome()
        val appName = context.getString(R.string.app_name)
        val appIconElement = device.findObject(By.text(appName))

        appIconElement.click()

        device.wait(
            Until.hasObject(By.text(UserInterfaceCalculatorCharacters.CLEAN.value)),
            LAUNCH_TIMEOUT
        )

        val cleanButtonElement =
            device.findObject(By.text(UserInterfaceCalculatorCharacters.CLEAN.value))

        cleanButtonElement.click()
    }

    @Test
    fun testIfCalculationIsExecutedOnUserInterface() {
        val oneButtonElement =
            device.findObject(By.text(UserInterfaceCalculatorCharacters.ONE.value))
        val additionButtonElement =
            device.findObject(By.text(UserInterfaceCalculatorCharacters.ADDITION.value))
        val backspaceButtonElement =
            device.findObject(By.text(UserInterfaceCalculatorCharacters.BACKSPACE.value))
        val evaluateButtonElement =
            device.findObject(By.text(UserInterfaceCalculatorCharacters.EVALUATION.value))
        val cleanButtonElement =
            device.findObject(By.text(UserInterfaceCalculatorCharacters.CLEAN.value))

        oneButtonElement.click()
        additionButtonElement.click()
        oneButtonElement.click()
        backspaceButtonElement.click()
        oneButtonElement.click()
        evaluateButtonElement.click()
        cleanButtonElement.click()
    }

    @Test
    fun testIfToggleThemeIsExecutedOnUserInterface() {
        val toggleThemeButtonContentDescriptionElement =
            context.getString(R.string.actionbar_menu_toggle_night_mode_content_description)

        val toggleThemeButtonElement =
            device.findObject(By.desc(toggleThemeButtonContentDescriptionElement))

        toggleThemeButtonElement.click()
        toggleThemeButtonElement.click()
    }

    @Test
    fun testIfUserInterfaceStoresLastSessionCalculationExpression() {
        val oneButtonElement =
            device.findObject(By.text(UserInterfaceCalculatorCharacters.ONE.value))
        val additionButtonElement =
            device.findObject(By.text(UserInterfaceCalculatorCharacters.ADDITION.value))
        val evaluateButtonElement =
            device.findObject(By.text(UserInterfaceCalculatorCharacters.EVALUATION.value))

        oneButtonElement.click()
        additionButtonElement.click()
        oneButtonElement.click()
        evaluateButtonElement.click()

        runBlocking {
            delay(KEY_VALUE_DATABASE_STORING_DELAY)

            val storedCalculationExpression =
                CalculationExpressionStore.getStoredCalculationExpression(context)

            assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, storedCalculationExpression)
        }
    }

    @Test
    fun testIfUserInterfaceStoresLastTheme() {
        val toggleThemeButtonContentDescriptionElement =
            context.getString(R.string.actionbar_menu_toggle_night_mode_content_description)

        val toggleThemeButtonElement =
            device.findObject(By.desc(toggleThemeButtonContentDescriptionElement))

        toggleThemeButtonElement.click()

        runBlocking {
            delay(KEY_VALUE_DATABASE_STORING_DELAY)

            val storedTheme =
                UserInterfaceThemeStore.getNightModeThemeState(context)

            assertTrue(storedTheme)
        }
        
        toggleThemeButtonElement.click()
    }

    companion object {
        private val instrumentation = InstrumentationRegistry.getInstrumentation()
        private val device = UiDevice.getInstance(instrumentation)

        @AfterClass
        @JvmStatic
        fun afterAll() {
            device.pressHome()
        }
    }
}