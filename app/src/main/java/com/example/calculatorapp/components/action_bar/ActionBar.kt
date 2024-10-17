package com.example.calculatorapp.components.action_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.theme.Theme

@Composable
fun ActionBar(
    actionIconDrawableResourceId: Int,
    actionContentDescriptionStringResourceId: Int,
    onActionButtonClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = Modifier
            .background(Theme.colors.viewfinderBackgroundColor)
            .then(actionBarContainerModifier),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Box(
            modifier = actionBarActionButtonModifier
                .clickable(
                    onClick = onActionButtonClick,
                    indication = rememberRipple(
                        color = Theme.colors.rippleColor,
                        bounded = true,
                        radius = 24.dp
                    ),
                    interactionSource = interactionSource
                ), contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = actionIconDrawableResourceId),
                contentDescription = stringResource(id = actionContentDescriptionStringResourceId)
            )
        }
    }
}
