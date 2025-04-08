package com.mydaily.mydailycoverapp.presentation.feature.foodBlogPrompt

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mydaily.mydailycoverapp.ui.component.button.DefaultButton
import com.mydaily.mydailycoverapp.ui.component.text.SubTitleText
import com.mydaily.mydailycoverapp.ui.theme.CustomColor
import com.mydaily.mydailycoverapp.ui.util.Tborder

@Composable
fun MadeFoodBlogModal(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
    onCancel: () -> Unit,
    text: String
) {
    val scrollState = rememberScrollState()

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.8f)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // ✅ 내용 부분 (비워둠)
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 16.dp, bottom = 16.dp)
                            .padding(horizontal = 16.dp)
                            .verticalScroll(scrollState)
                            .imePadding()
                    ) {
                        SubTitleText(
                            title = text
                        )
                    }

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    DefaultButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(80.dp)
                            .background(
                        color = CustomColor.mainLight,

                    )
                    ) {
                        SubTitleText(title = "닫기")
                    }
                    DefaultButton(
                        onClick = { onConfirm() },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(80.dp)
                            .background(
                        color = CustomColor.sub,

                    )
                    ) {
                        SubTitleText(title = "복사하기", color = CustomColor.white)
                    }
                }
            }
        }
    }
}