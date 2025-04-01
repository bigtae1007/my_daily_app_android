package com.mydaily.mydailycoverapp.presentation.feature.foodBlogPrompt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mydaily.mydailycoverapp.ui.component.TextField.SimpleTextField
import com.mydaily.mydailycoverapp.ui.component.TextField.SimpleTextFieldWithTitle
import com.mydaily.mydailycoverapp.ui.component.header.MiddleTitleHeader
import com.mydaily.mydailycoverapp.ui.component.icon.SvgBackButton

@Composable
fun FoodBlogPromptScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    val inputFields = listOf(
        InputFieldData("storeName", "식당 이름", "식당 이름을 입력해주세요.", value = ""),
        InputFieldData("place", "장소", "위치를 입력해주세요.", value = ""),
        InputFieldData("date", "날짜", "날짜를 입력해주세요.", value = ""),
        InputFieldData("eatingMenus", "메뉴", "\",\"를 기준으로 나열해주세요.", value = ""),
        InputFieldData("flavor", "맛", "전반적인 맛 평가를 해주세요.", value = ""),
        InputFieldData("recommendedTarget", "추천 대상", "누구에게 추천하시겠어요?", value = ""),
        InputFieldData("atmosphere", "분위기", "가게 분위기를 설명해주세요.", value = ""),
        InputFieldData("overallReview", "분위기", "최종 평가를 입력해주세요.", value = ""),
        InputFieldData("pictureKeyword", "분위기", "내가 가지고 있는 사진의 키워드를 ','로 구분하여 나열해주세요.", value = ""),
        InputFieldData("elseReview", "분위기", "그 외에 추가하고 싶은 내용을 적어주세요.", value = ""),
    )

    MiddleTitleHeader(Modifier.fillMaxWidth(), title = "음식 블로그", leftContent = {
        IconButton(onClick = { /*TODO*/ }) {
            SvgBackButton(navController = navController)
        }
    })

    Column(
        modifier = Modifier
            .padding(top = 72.dp, bottom = 16.dp)
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState)
    ) {
        inputFields.forEachIndexed { index, inputFieldData ->
            SimpleTextFieldWithTitle(
                title = inputFieldData.title,
                placeholder = inputFieldData.placeholder,
                value = inputFieldData.value
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