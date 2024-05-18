package com.example.calculatorapp.unitaries.components.button

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.calculatorapp.components.button.Button
import com.example.calculatorapp.theme.Theme
import com.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private var state = false

    @Before
    fun beforeEach() {
        composeTestRule.setContent {
            Button(
                UserInterfaceCalculatorCharacters.ONE,
                Theme.colors.primaryBlueButtonCharacterColor,
                Theme.colors.primaryBlueButtonBackgroundColor,
                Theme.colors.primaryBlueButtonBorderColor
            ) {
                state = !state
            }
        }
    }

    @Test
    fun testIfComponentIsRenderedAndDispatchesItsEvent() {
        composeTestRule.onNodeWithText(UserInterfaceCalculatorCharacters.ONE.value).performClick()

        assertTrue(state)
    }
}
