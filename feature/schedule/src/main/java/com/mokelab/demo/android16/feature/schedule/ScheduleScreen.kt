package com.mokelab.demo.android16.feature.schedule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mokelab.demo.android16.core.design.component.MediumText
import com.mokelab.demo.android16.core.design.component.Screen
import java.util.concurrent.Executors

private val executor = Executors.newScheduledThreadPool(1)

@Composable
fun ScheduleScreen() {
    var count by remember { mutableIntStateOf(0) }

    Screen { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            MediumText("count $count")
        }
    }

    LaunchedEffect(Unit) {
        executor.scheduleAtFixedRate({
            count++
            println("task $count")
        }, 1000, 100, java.util.concurrent.TimeUnit.MILLISECONDS)
    }
}