package com.mokelab.demo.android16

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mokelab.demo.android16.feature.menu.MenuItem
import com.mokelab.demo.android16.feature.menu.MenuScreen
import com.mokelab.demo.android16.feature.optout16kb.ScannerScreen
import com.mokelab.demo.android16.feature.optout16kb.ScannerViewModel
import com.mokelab.demo.android16.feature.schedule.ScheduleScreen
import com.mokelab.demo.android16.feature.verticaltext.VerticalTextScreen
import com.mokelab.demo.android16.feature.vibrator.VibratorScreen
import kotlinx.serialization.Serializable

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Top) {
        composable<Top> {
            MenuScreen(
                menuItems = listOf(
                    MenuItem(stringResource(R.string.qr_code_scanner)) {
                        navController.navigate(Scanner)
                    },
                    MenuItem(stringResource(R.string.schedule_at_fixed_rate)) {
                        navController.navigate(Schedule)
                    },
                    MenuItem(stringResource(R.string.vibrator)) {
                        navController.navigate(Vibrator)
                    },
                    MenuItem(stringResource(R.string.vertical_text)) {
                        navController.navigate(VerticalText)
                    },
                )
            )
        }
        composable<Scanner> {
            val viewModel: ScannerViewModel = hiltViewModel()
            ScannerScreen(
                viewModel = viewModel,
                back = { navController.popBackStack() }
            )
        }
        composable<Schedule> {
            ScheduleScreen()
        }
        composable<Vibrator> {
            VibratorScreen(
                back = { navController.popBackStack() }
            )
        }
        composable<VerticalText> {
            VerticalTextScreen(
                back = { navController.popBackStack() }
            )
        }
    }
}

@Serializable
data object Top

@Serializable
data object Scanner

@Serializable
data object Schedule

@Serializable
data object Vibrator

@Serializable
data object VerticalText

