package com.example.calculatorapp.unitaries.components.action_bar

import android.content.Context
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.example.calculatorapp.R
import com.example.calculatorapp.components.action_bar.ActionBar
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ActionBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    private var state = false

    @Before
    fun beforeEach() {
        composeTestRule.setContent {
            ActionBar(
                actionIconDrawableResourceId = R.drawable.white_balance_sunny,
                actionContentDescriptionStringResourceId = R.string.actionbar_menu_toggle_night_mode_content_description
            ) {
                state = !state
            }
        }
    }

    @Test
    fun testIfComponentIsRenderedAndDispatchesItsEvent() {
        val actionbarMenuToggleNightModeContentDescription =
            context.getString(R.string.actionbar_menu_toggle_night_mode_content_description)

        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()

        assertTrue(state)

        composeTestRule.onNodeWithContentDescription(actionbarMenuToggleNightModeContentDescription)
            .performClick()

        assertFalse(state)
    }
}