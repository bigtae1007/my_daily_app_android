package com.mydaily.mydailycoverapp.ui.component.header

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mydaily.mydailycoverapp.ui.component.text.TitleText
import com.mydaily.mydailycoverapp.ui.util.headerBottomBorder

@Composable
fun MiddleTitleHeader(
    modifier: Modifier = Modifier,
    title: String = "hello",
    leftContent: @Composable (() -> Unit)? = null,
    rightContent: @Composable (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .headerBottomBorder(thick = 2.dp)
            .height(60.dp),
    ) {
        Box(
            modifier = Modifier
                .matchParentSize(), // 부모 영역 전체
            contentAlignment = Alignment.Center
        ) {
            TitleText(title = title)
        }

        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Box(modifier = Modifier.padding(start = 0.dp)) {
                leftContent?.invoke()
            }
            Box(modifier = Modifier.padding(end = 0.dp)) {
                rightContent?.invoke()
            }
        }
    }
}