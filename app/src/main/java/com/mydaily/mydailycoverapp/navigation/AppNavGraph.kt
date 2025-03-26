package com.mydaily.mydailycoverapp.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myDaily.MyDailyApp.presentation.feature.home.HomeScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.HOME
    ) {
        composable(Route.HOME) {
            HomeScreen(navController)
        }
        composable(Route.FOOD_BLOG_PROMPT) {
            // TODO: 나중에 실제 화면 만들기
            Text("음식 블로그 프롬포트 화면")
        }
    }
}