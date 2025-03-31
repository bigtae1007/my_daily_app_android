package com.mydaily.mydailycoverapp.ui.component.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun rememberInputState(
    initial: String = "",
    checkChange: ((text: String) -> String)? = null
): InputState {
    val value = remember { mutableStateOf(initial) }

    return InputState(
        value = value.value,
        onValueChange = {
            val checked = checkChange?.invoke(it)
            value.value = checked ?: it
        }
    )
}

data class InputState(
    val value: String,
    val onValueChange: (String) -> Unit
)