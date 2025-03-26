package com.mydaily.mydailycoverapp.presentation.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mydaily.mydailycoverapp.ui.component.text.SubTitleText


@Composable
fun HomeMenuSection(title: String, items: ItemList, index: Int) {

    Column(Modifier.padding(
        horizontal = 8.dp
    )) {

        Box(modifier = Modifier.padding(horizontal = 8.dp)) {
            SubTitleText(title = title)
        }

        items.forEachIndexed() { index, item ->
            HomeMenuItem(title = item.title, onClick = item.onClick, index = index)
        }

    }

}

typealias ItemList = List<MenuItem>

data class MenuSection(val title: String, val items: ItemList)