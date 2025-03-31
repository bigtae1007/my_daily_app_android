package com.mydaily.mydailycoverapp.ui.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mydaily.mydailycoverapp.ui.theme.CustomColor

@Composable
fun TitleText(title: String, color: Color = CustomColor.font) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge.copy(fontSize = 20.sp),
        fontWeight = FontWeight(900),
        color = color
    )
}

@Composable
fun SubTitleText(title: String, color: Color = CustomColor.font) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge.copy(fontSize = 16.sp),
        fontWeight = FontWeight(700),
        color = color
    )
}

@Composable
fun DescText(title: String, color: Color = CustomColor.font) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge.copy(fontSize = 14.sp),
        fontWeight = FontWeight(400),
        color = color
    )
}

@Composable
fun CaptionText(title: String, color: Color = CustomColor.font) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge.copy(fontSize = 10.sp),
        fontWeight = FontWeight(300),
        color = color
    )
}

@Composable
fun PlaceholderText(title: String, color: Color = CustomColor.dimFont) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineLarge.copy(fontSize = 14.sp),
        fontWeight = FontWeight(400),
        color = color
    )
}