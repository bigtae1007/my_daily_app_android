// presentation/feature/home/HomeScreen.kt
package com.myDaily.MyDailyApp.presentation.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mydaily.mydailycoverapp.navigation.Route
import com.mydaily.mydailycoverapp.presentation.feature.home.HomeMenuSection
import com.mydaily.mydailycoverapp.presentation.feature.home.MenuItem
import com.mydaily.mydailycoverapp.presentation.feature.home.MenuSection
import com.mydaily.mydailycoverapp.ui.component.header.AppMainHeader
import com.mydaily.mydailycoverapp.ui.component.sperate.GrayBlank


@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val promptList = listOf(
        MenuSection(
            title = "블로그 만들기", items = listOf(
                MenuItem(
                    title = "음식 블로그 프롬포트",
                    onClick = { navController.navigate(Route.FOOD_BLOG_PROMPT) }),
                MenuItem(
                    title = "음식 블로그 프롬포트",
                    onClick = { navController.navigate(Route.FOOD_BLOG_PROMPT) }),
                MenuItem(
                    title = "음식 블로그 프롬포트",
                    onClick = { navController.navigate(Route.FOOD_BLOG_PROMPT) })
            )
        ), MenuSection(
            title = "블로그 만들기", items = listOf(
                MenuItem(
                    title = "음식 블로그 프롬포트",
                    onClick = { navController.navigate(Route.FOOD_BLOG_PROMPT) }),
                MenuItem(
                    title = "음식 블로그 프롬포트",
                    onClick = { navController.navigate(Route.FOOD_BLOG_PROMPT) }),
                MenuItem(
                    title = "음식 블로그 프롬포트",
                    onClick = { navController.navigate(Route.FOOD_BLOG_PROMPT) })
            )
        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // ✅ 고정 헤더
        AppMainHeader(
            title = "Menu", modifier = Modifier.fillMaxWidth()
        )

        // ✅ 스크롤 가능한 리스트 (헤더 높이만큼 아래로 패딩)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 60.dp) // 헤더 높이만큼 아래로 밀어줌
                .verticalScroll(scrollState)
        ) {
            promptList.forEachIndexed { index, group ->
                if (index != 0) GrayBlank()

                HomeMenuSection(
                    title = group.title, items = group.items, index = index
                )
            }
        }
    }
}