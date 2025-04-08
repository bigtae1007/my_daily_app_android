package com.mydaily.mydailycoverapp.ui.util

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.headerBottomBorder(color: Color = Color.Gray, thick: Dp = 1.dp): Modifier {
    return this.drawBehind {
        val strokeWidth = thick.toPx()
        val y = size.height - strokeWidth / 2
        drawLine(
            color,
            Offset(0f, y),
            Offset(size.width, y),
            strokeWidth
        )
    }
}


fun Modifier.Tborder(color: Color = Color.Gray, thick: Dp = 1.dp): Modifier {
    return this.drawBehind {
        val strokeWidth = thick.toPx()
        drawRect(
            color = color,
            size = size,
            style = Stroke(width = strokeWidth)
        )
    }
}