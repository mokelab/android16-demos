package com.mokelab.android16demo.core.design


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun Screen(
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        content = content,
    )
}