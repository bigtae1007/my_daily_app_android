package com.mydaily.mydailycoverapp.ui.component.icon

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mydaily.mydailycoverapp.R

@Composable
fun SvgBackButton(navController: NavController) {
    IconButton(onClick = { navController.popBackStack() }) {
        SvgBack()
    }
}

@Composable
private fun SvgBack() {
    DefaultIconCompose(resId = R.drawable.back_24, size = 24.dp)
}