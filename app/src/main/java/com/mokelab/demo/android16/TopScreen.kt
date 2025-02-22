package com.mokelab.demo.android16

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mokelab.demo.android16.core.design.component.ListItem
import com.mokelab.demo.android16.core.design.component.MediumText
import com.mokelab.demo.android16.core.design.component.Screen

@Composable
fun TopScreen(
    toScanner: () -> Unit,
) {
    val menuItems = listOf(
        TopMenuItem(
            title = stringResource(R.string.qr_code_scanner),
            onClick = toScanner,
        ),
    )
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

private class TopMenuItem(
    val title: String,
    val onClick: () -> Unit,
)