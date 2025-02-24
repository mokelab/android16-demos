package com.mokelab.demo.android16.app35

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mokelab.demo.android16.feature.menu.MenuItem
import com.mokelab.demo.android16.feature.menu.MenuScreen
import com.mokelab.demo.android16.feature.schedule.ScheduleScreen
import kotlinx.serialization.Serializable

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Top) {
        composable<Top> {
            MenuScreen(
                menuItems = listOf(
                    MenuItem(stringResource(R.string.schedule_at_fixed_rate)) {
                        navController.navigate(Schedule)
                    },
                )
            )
        }
        composable<Schedule> {
            ScheduleScreen()
        }
    }
}

@Serializable
data object Top

@Serializable
data object Schedule

