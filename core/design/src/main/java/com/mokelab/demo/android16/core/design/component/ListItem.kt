package com.mokelab.demo.android16.core.design.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    headlineContent: @Composable (() -> Unit) = {},
    trailingContent: @Composable (() -> Unit)? = null,
) {
    androidx.compose.material3.ListItem(
        modifier = modifier,
        headlineContent = headlineContent,
        trailingContent = trailingContent,
    )
}