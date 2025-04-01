package com.mydaily.mydailycoverapp.presentation.feature.foodBlogPrompt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mydaily.mydailycoverapp.ui.component.TextField.SimpleTextFieldWithTitle
import com.mydaily.mydailycoverapp.ui.component.header.MiddleTitleHeader
import com.mydaily.mydailycoverapp.ui.component.icon.SvgBackButton

@Composable
fun FoodBlogPromptScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    val inputFields = listOf(
        InputFieldData("storeName", "식당 이름", "식당 이름을 입력해주세요.", value = ""),
        InputFieldData("place", "주소 (**동 또는 **점)", "위치를 입력해주세요.", value = ""),
        InputFieldData("date", "방문 날짜", "날짜를 입력해주세요.", value = ""),
        InputFieldData("eatingMenus", "먹은 메뉴", "\" , \"를 기준으로 나열해주세요.", value = ""),
        InputFieldData("flavor", "맛", "전반적인 맛 평가를 해주세요.", value = ""),
        InputFieldData("recommendedTarget", "추천 대상", "누구에게 추천하시겠어요?", value = ""),
        InputFieldData("atmosphere", "분위기", "가게 분위기를 설명해주세요.", value = ""),
        InputFieldData("overallReview", "총평", "최종 평가를 입력해주세요.", value = ""),
        InputFieldData("pictureKeyword", "사진 키워드", "가지고 있는 사진을 \" , \"로 구분하여 나열해주세요.", value = ""),
        InputFieldData("elseReview", "외에 추가 사항", "그 외에 추가하고 싶은 내용을 적어주세요.", value = ""),
    )

    val focusRequesters = remember {
        List(inputFields.size) { FocusRequester() }
    }

    LaunchedEffect(Unit) {
        focusRequesters.first().requestFocus()
    }

    MiddleTitleHeader(Modifier.fillMaxWidth(), title = "음식 블로그", leftContent = {
        IconButton(onClick = { /*TODO*/ }) {
            SvgBackButton(navController = navController)
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
                singleLine = inputFieldData.key != "elseReview",
                focusRequester = focusRequesters[index],
                onNext = {
                    if (index < focusRequesters.lastIndex) {
                        focusRequesters[index + 1].requestFocus()
                    }
                },
                imeAction = if (index < focusRequesters.lastIndex) ImeAction.Next else ImeAction.Default
            )
        }

    }
}

data class InputFieldData(
    val key: String, // state 관리용 키 (선택)
    val title: String,
    val placeholder: String,
    val value: String
)