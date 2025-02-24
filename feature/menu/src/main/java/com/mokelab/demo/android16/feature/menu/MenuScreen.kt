package com.mokelab.demo.android16.feature.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mokelab.demo.android16.core.design.component.ListItem
import com.mokelab.demo.android16.core.design.component.MediumText
import com.mokelab.demo.android16.core.design.component.Screen

@Composable
fun MenuScreen(
    menuItems: List<MenuItem>,
) {
    Screen { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
        ) {
            items(menuItems) { item ->
                ListItem(
                    headlineContent = { MediumText(item.title) },
                    modifier = Modifier.clickable { item.onClick() },
                )
            }
        }
    }
}

class MenuItem(
    val title: String,
    val onClick: () -> Unit,
)