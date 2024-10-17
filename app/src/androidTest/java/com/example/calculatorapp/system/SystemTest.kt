package com.example.calculatorapp.system

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import com.example.calculatorapp.R
import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore
import com.example.calculatorapp.constants.ApplicationConstants
import com.example.calculatorapp.constants.domains.CalculatorConstants
import com.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.AfterClass
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SystemTest {
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Before
    fun beforeEach() {
        device.pressHome()
        val appName = context.getString(R.string.app_name)
        val appIconElement = device.findObject(By.text(appName))

        appIconElement.click()

        device.wait(
            Until.hasObject(By.text(UserInterfaceCalculatorCharacters.CLEAN.value)),
            ApplicationConstants.LAUNCH_TIMEOUT
        )

        val cleanButtonElement =
            device.findObject(By.text(UserInterfaceCalculatorCharacters.CLEAN.value))

        cleanButtonElement.click()
    }

    @Test
    fun testIfCalculationIsExecutedAndStoredInKeyValueDatabaseOnUserInterface() {
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
            delay(ApplicationConstants.KEY_VALUE_DATABASE_STORING_DELAY)

            val storedCalculationExpression =
                CalculationExpressionStore.getStoredCalculationExpression(context)

            assertEquals(
                CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION,
                storedCalculationExpression
            )
        }
    }

    @Test
    fun testIfToggleThemeIsExecutedOnAndStoredInKeyValueDatabaseOnUserInterface() {
        val toggleThemeButtonContentDescriptionElement =
            context.getString(R.string.actionbar_menu_toggle_night_mode_content_description)

        val toggleThemeButtonElement =
            device.findObject(By.desc(toggleThemeButtonContentDescriptionElement))

        toggleThemeButtonElement.click()

        runBlocking {
            delay(ApplicationConstants.KEY_VALUE_DATABASE_STORING_DELAY)

            val storedTheme =
                UserInterfaceThemeStore.getNightModeThemeState(context)

            Assert.assertTrue(storedTheme)
        }
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