package com.mydaily.mydailycoverapp.ui.component.TextField

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.mydaily.mydailycoverapp.ui.component.text.DescText

@Composable
fun SimpleTextFieldWithTitle(
    title: String = "",
    checkChange: ((text: String) -> String)? = null,
    placeholder: String? = "",
    singleLine: Boolean = true,
    value: String,
    onNext: (() -> Unit)? = null,
    focusRequester: FocusRequester? = null,
    imeAction: ImeAction = ImeAction.Default
) {
    Column(modifier = Modifier) {
        Box(modifier = Modifier) {
            DescText(title = title)
        }
        Box(modifier = Modifier.padding(start = 10.dp)) {
            SimpleTextField(
                initValue = value,
                checkChange = checkChange,
                placeholder = placeholder,
                singleLine = singleLine,
                focusRequester = focusRequester,
                onNext = onNext,
                imeAction = imeAction
            )
        }
    }

}