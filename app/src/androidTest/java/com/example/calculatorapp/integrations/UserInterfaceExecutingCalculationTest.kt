package com.example.calculatorapp.integrations

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import com.example.calculatorapp.R
import com.example.calculatorapp.constants.ApplicationConstants
import com.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
import org.junit.AfterClass
import org.junit.Before
import org.junit.Test

class UserInterfaceExecutingCalculationTest {
    private lateinit var context: Context

    @Before
    fun beforeEach() {
        context = InstrumentationRegistry.getInstrumentation().targetContext

        device.pressHome()

        val appName = context.getString(R.string.app_name)
        val appIconElement = device.findObject(By.text(appName))

        appIconElement.click()

        device.wait(
            Until.hasObject(By.text(UserInterfaceCalculatorCharacters.CLEAN.value)),
            ApplicationConstants.LAUNCH_TIMEOUT
        )
    }

    @Test
    fun testIfCalculationExpressionIsExecutedOnUserInterface() {
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