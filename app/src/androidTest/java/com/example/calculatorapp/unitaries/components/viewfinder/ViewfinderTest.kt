package com.example.calculatorapp.unitaries.components.viewfinder

import androidx.compose.foundation.ScrollState
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.calculatorapp.components.viewfinder.Viewfinder
import com.example.calculatorapp.constants.INITIAL_VIEWFINDER_SCROLL_POSITION
import com.example.calculatorapp.constants.LONG_CALCULATION_EXPRESSION
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ViewfinderTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val scrollState = ScrollState(INITIAL_VIEWFINDER_SCROLL_POSITION)

    @Before
    fun beforeEach() {
        composeTestRule.setContent {
            Viewfinder(LONG_CALCULATION_EXPRESSION, scrollState)
        }
    }

    @Test
    fun testIfComponentIsRenderedAndIsScrolled() {
        composeTestRule.onNodeWithText(LONG_CALCULATION_EXPRESSION).assert(hasScrollAction())
    }
}