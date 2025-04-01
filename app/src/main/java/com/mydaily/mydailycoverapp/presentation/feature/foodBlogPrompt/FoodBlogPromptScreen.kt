package com.mydaily.mydailycoverapp.presentation.feature.foodBlogPrompt

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mydaily.mydailycoverapp.domain.model.FoodBlogPromptInputFieldData
import com.mydaily.mydailycoverapp.ui.component.TextField.SimpleTextFieldWithTitle
import com.mydaily.mydailycoverapp.ui.component.button.DefaultButton
import com.mydaily.mydailycoverapp.ui.component.header.MiddleTitleHeader
import com.mydaily.mydailycoverapp.ui.component.icon.SvgBackButton
import com.mydaily.mydailycoverapp.ui.component.text.DescText
import com.mydaily.mydailycoverapp.ui.theme.CustomColor
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FoodBlogPromptScreen(
    navController: NavHostController,
    viewModel: FoodBlogPromptViewModel = viewModel()
) {
    val scrollState = rememberScrollState()
    val inputFields by viewModel.inputFields.collectAsState()

    Log.d("TAG", "FoodBlogPromptScreen: $inputFields")
    LaunchedEffect(Unit) {
        viewModel.focusRequesters.first().requestFocus()
    }

//    View
    MiddleTitleHeader(Modifier.fillMaxWidth(), title = "음식 블로그", leftContent = {
        SvgBackButton(navController = navController)
    }, rightContent = {
        DefaultButton(onClick = { /*TODO*/ }) {
            DescText(title = "만들기", color = CustomColor.sub)
        }
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 72.dp, bottom = 16.dp)
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState)
            .imePadding()
    ) {
        inputFields.forEachIndexed { index, inputFieldData ->
            SimpleTextFieldWithTitle(
                title = inputFieldData.title,
                placeholder = inputFieldData.placeholder,
                value = inputFieldData.value,
                onChange = { viewModel.updateFieldValue(index, it) },
                singleLine = inputFieldData.key != "elseReview",
                focusRequester = viewModel.focusRequesters[index],
                onNext = { viewModel.focusNext(index) },
                imeAction = if (index < viewModel.focusRequesters.lastIndex) ImeAction.Next else ImeAction.Default
            )
        }

    }
}

