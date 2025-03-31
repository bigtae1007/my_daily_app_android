package com.mydaily.mydailycoverapp.ui.component.icon

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DefaultIconCompose(
    resId: Int,
    modifier: Modifier = Modifier,
    size: Dp,
    contentDescription: String? = null,
    tint: Color = Color.Unspecified
) {
    Icon(
        painter = painterResource(id = resId),
        contentDescription = contentDescription,
        modifier = modifier.size(size),
        tint = tint
    )
}