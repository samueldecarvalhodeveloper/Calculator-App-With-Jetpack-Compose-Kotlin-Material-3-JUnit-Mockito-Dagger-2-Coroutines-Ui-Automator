package com.example.calculatorapp.infrastructure.specifications

import androidx.compose.ui.unit.Dp
import com.example.calculatorapp.constants.SMALL_SCREEN_HEIGHT

fun isScreenHeightSmall(currentScreenHeight: Dp): Boolean {
    return currentScreenHeight < SMALL_SCREEN_HEIGHT
}

fun isRetrievedValueEqualToNull(retrievedValue: Any?): Boolean {
    return retrievedValue == null
}
