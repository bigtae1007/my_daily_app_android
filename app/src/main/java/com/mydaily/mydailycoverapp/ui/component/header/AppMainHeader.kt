package com.mydaily.mydailycoverapp.ui.component.header

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mydaily.mydailycoverapp.ui.component.text.TitleText
import com.mydaily.mydailycoverapp.ui.util.bottomBorder

@Composable
fun AppMainHeader(title: String, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .bottomBorder(thick = 2.dp)
            .padding(vertical = 10.dp, horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        TitleText(
            title,
        )
    }
}
