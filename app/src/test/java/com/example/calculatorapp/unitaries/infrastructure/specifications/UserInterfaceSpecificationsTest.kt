package com.example.calculatorapp.unitaries.infrastructure.specifications

import com.example.calculatorapp.constants.LARGER_SCREEN_WIDTH
import com.example.calculatorapp.constants.SMALLER_SCREEN_WIDTH
import com.example.calculatorapp.infrastructure.specifications.isRetrievedValueEqualToNull
import com.example.calculatorapp.infrastructure.specifications.isScreenHeightSmall
import net.bytebuddy.matcher.ElementMatchers.any
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UserInterfaceSpecificationsTest {
    @Test
    fun testIfMethodIsScreenHeightSmallReturnsTrueWhenDeviceScreenIsSmaller() {
        val userInterfaceIsSmall = isScreenHeightSmall(SMALLER_SCREEN_WIDTH)
        val userInterfaceIsLarge = isScreenHeightSmall(LARGER_SCREEN_WIDTH)

        assertTrue(userInterfaceIsSmall)
        assertFalse(userInterfaceIsLarge)
    }

    @Test
    fun testIfMethodIsRetrievedValueEqualToNullReturnsTrueWhen() {
        val nullRetrievedValue = isRetrievedValueEqualToNull(null)
        val notNullRetrievedValue = isRetrievedValueEqualToNull(any<String>())

        assertTrue(nullRetrievedValue)
        assertFalse(notNullRetrievedValue)
    }
}