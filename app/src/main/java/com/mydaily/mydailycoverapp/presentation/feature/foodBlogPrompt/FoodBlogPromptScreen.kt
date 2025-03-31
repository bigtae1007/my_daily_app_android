package com.mydaily.mydailycoverapp.presentation.feature.foodBlogPrompt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
    val storeName: String = ""
    val place: String = ""
    val date: String = ""
    val eatingMenus: String = ""
    val flavor: String = ""
    val atmosphere: String = ""
    val recommendedTarget: String = ""
    val overallReview: String = ""
    val pictureKeyword: String = ""
    val elseReview: String = ""

    MiddleTitleHeader(Modifier.fillMaxWidth(), title = "음식 블로그", leftContent = {
        IconButton(onClick = { /*TODO*/ }) {
            SvgBackButton(navController = navController)
        }
    })

    Column(modifier = Modifier.padding(top = 60.dp)) {
        SimpleTextFieldWithTitle(title = "식당 이름", placeholder = "식당 이름을 입력해주세요.")
    }
}