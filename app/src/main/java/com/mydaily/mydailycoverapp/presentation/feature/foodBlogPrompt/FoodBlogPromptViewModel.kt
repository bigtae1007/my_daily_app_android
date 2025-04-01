package com.mydaily.mydailycoverapp.presentation.feature.foodBlogPrompt

import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import com.mydaily.mydailycoverapp.domain.model.FoodBlogPromptInputFieldData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class FoodBlogPromptViewModel : ViewModel() {
    private val _inputFields = MutableStateFlow(
        listOf(
            FoodBlogPromptInputFieldData("storeName", "식당 이름", "청학동", ""),
            FoodBlogPromptInputFieldData("place", "주소 (**동 또는 **점)", "권선구 탑동", ""),
            FoodBlogPromptInputFieldData("date", "방문 날짜", "240203", ""),
            FoodBlogPromptInputFieldData("eatingMenus", "먹은 메뉴", "제육볶음, 골뱅이 소면, 갈비찜", ""),
            FoodBlogPromptInputFieldData("flavor", "맛", "양념이 너무 맛있고 무난.....", ""),
            FoodBlogPromptInputFieldData("recommendedTarget", "추천 대상", "운동 후 뒷풀이 가고 싶어하는 사람들...", ""),
            FoodBlogPromptInputFieldData("atmosphere", "분위기", "아담하고 옛스러운 .....", ""),
            FoodBlogPromptInputFieldData("overallReview", "총평", "또 갈 의사가 100%. 맛은 보장하지만 가격대가 있어요", ""),
            FoodBlogPromptInputFieldData("pictureKeyword", "사진 키워드", "제육볶음, 가게 외관, 내부, 한상차림", ""),
            FoodBlogPromptInputFieldData("elseReview", "외에 추가 사항", "제가 자주 가는 곳, 주변에게 매번 추천할 수 있는....", "")
        )
    )
    val inputFields: StateFlow<List<FoodBlogPromptInputFieldData>> = _inputFields

    val focusRequesters: List<FocusRequester> = List(_inputFields.value.size) { FocusRequester() }

    fun updateFieldValue(index: Int, newValue: String) {
        _inputFields.update { currentList ->
            currentList.mapIndexed { i, field ->
                if (i == index) field.copy(value = newValue) else field
            }
        }
    }

    fun focusNext(currentIndex: Int) {
        if (currentIndex < focusRequesters.lastIndex) {
            focusRequesters[currentIndex + 1].requestFocus()
        }
    }
}


