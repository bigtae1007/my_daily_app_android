package com.mydaily.mydailycoverapp.ui.component.sperate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mydaily.mydailycoverapp.ui.theme.CustomColor

@Composable
fun GrayBlank(height : Dp = 15.dp){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(height).background(CustomColor.gray700))
}