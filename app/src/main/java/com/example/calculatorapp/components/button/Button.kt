package com.example.calculatorapp.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.infrastructure.specifications.isScreenHeightSmall
import com.example.calculatorapp.theme.Theme
import com.example.calculatorapp.user_interface_calculator_characters.UserInterfaceCalculatorCharacters

@Composable
fun Button(
    character: UserInterfaceCalculatorCharacters,
    characterColor: Color,
    backgroundColor: Color,
    borderColor: Color,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Box(
        modifier = buttonBorderContainerModifier
            .background(borderColor)
            .padding(1.dp)
            .clickable(
                onClick = onClick, indication = rememberRipple(
                    color = Theme.colors.rippleColor,
                    bounded = true,
                    radius = screenWidth,
                ),
                interactionSource = interactionSource
            )
    ) {
        Box(
            modifier = buttonBackgroundContainerModifier
                .background(backgroundColor),
            contentAlignment = Alignment.Center
        ) {
            BasicText(
                text = character.value,
                style = TextStyle(
                    color = characterColor,
                    fontSize = if (isScreenHeightSmall(screenHeight)) 26.sp else 42.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}
