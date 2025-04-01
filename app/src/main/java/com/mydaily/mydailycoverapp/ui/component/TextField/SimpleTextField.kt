package com.mydaily.mydailycoverapp.ui.component.TextField

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.mydaily.mydailycoverapp.ui.component.text.PlaceholderText
import com.mydaily.mydailycoverapp.ui.theme.CustomColor

@Composable
fun SimpleTextField(
    initValue: String,
    checkChange: ((text: String) -> String)? = null,
    placeholder: String? = "",
    singleLine: Boolean = true,
    focusRequester: FocusRequester? = null,
    onNext: (() -> Unit)? = null,
    imeAction :ImeAction = ImeAction.Default
) {
    val input = rememberInputState(initial = initValue, checkChange = checkChange)

    BasicTextField(
        value = input.value,
        onValueChange = input.onValueChange,
        singleLine = singleLine,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                Log.d("SimpleTextField", "Action onNext")
                onNext?.invoke()
            }
        ),
        textStyle = TextStyle.Default.copy(color = CustomColor.font),
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 50.dp)
            .then(focusRequester?.let { Modifier.focusRequester(it) } ?: Modifier),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = CustomColor.gray900,
                        shape = RoundedCornerShape(18.dp)
                    )
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                if (input.value.isEmpty()) {
                    PlaceholderText(placeholder ?: "")
                }
                innerTextField() // ✅ 실제 텍스트 입력 필드
            }
        }
    )
}