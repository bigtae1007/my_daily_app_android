package com.mydaily.mydailycoverapp.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.myDaily.MyDailyApp.presentation.feature.home.HomeScreen
import com.mydaily.mydailycoverapp.presentation.feature.foodBlogPrompt.FoodBlogPromptScreen

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
            FoodBlogPromptScreen(navController)
        }
    }
}