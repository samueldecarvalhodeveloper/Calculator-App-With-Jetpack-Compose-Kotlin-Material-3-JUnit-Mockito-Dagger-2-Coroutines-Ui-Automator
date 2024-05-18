package com.example.calculatorapp.components.keyboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.infrastructure.specifications.isScreenHeightSmall

@Composable
fun Keyboard(content: @Composable () -> Unit) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Column(
        KeyboardModifier
            .padding(
                top = if (isScreenHeightSmall(screenHeight)) 16.dp else 32.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = if (isScreenHeightSmall(screenHeight)) 4.dp else 8.dp
            )
    ) {
        content()
    }
}