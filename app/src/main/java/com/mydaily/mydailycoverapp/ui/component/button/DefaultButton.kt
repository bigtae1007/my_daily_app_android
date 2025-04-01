package com.mydaily.mydailycoverapp.ui.component.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.mydaily.mydailycoverapp.ui.theme.CustomColor

@Composable
fun DefaultButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    normalColor: Color = CustomColor.trans,
    pressedColor: Color = CustomColor.alphaBackground,
    contentColor: Color = CustomColor.white,
    shape: Shape = RoundedCornerShape(12.dp),
    content: @Composable () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    // ✅ 현재 누른 상태인지 감지
    val isPressed by interactionSource.collectIsPressedAsState()

    // ✅ 색상 애니메이션
    val backgroundColor by animateColorAsState(
        targetValue = if (isPressed) pressedColor else normalColor,
        label = "backgroundColor"
    )

    Button(
        onClick = onClick,
        modifier = modifier,
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = shape,
        elevation = null,
        contentPadding = PaddingValues(0.dp)
    ) {
        content()
    }
}