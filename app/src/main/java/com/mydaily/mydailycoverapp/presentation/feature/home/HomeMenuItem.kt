package com.mydaily.mydailycoverapp.presentation.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mydaily.mydailycoverapp.ui.component.button.AnimatedButton
import com.mydaily.mydailycoverapp.ui.component.text.CaptionText
import com.mydaily.mydailycoverapp.ui.component.text.DescText
import com.mydaily.mydailycoverapp.ui.theme.CustomColor

@Composable
fun HomeMenuItem(title: String, onClick: () -> Unit, index: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        AnimatedButton(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            pressedColor = CustomColor.gray800
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DescText(title, color = CustomColor.font)
                CaptionText(">", color = CustomColor.dimFont)
            }
        }
    }
}


data class MenuItem(
    val title: String,
    val onClick: () -> Unit,
    val icon: String = "",
    val caption: String = ""
)
