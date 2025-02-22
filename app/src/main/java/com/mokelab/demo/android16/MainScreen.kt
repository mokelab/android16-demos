package com.mokelab.demo.android16

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mokelab.demo.android16.feature.optout16kb.ScannerScreen
import com.mokelab.demo.android16.feature.optout16kb.ScannerViewModel
import kotlinx.serialization.Serializable

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Top) {
        composable<Top> {
            TopScreen(
                toScanner = {
                    navController.navigate(Scanner)
                }
            )
        }
        composable<Scanner> {
            val viewModel: ScannerViewModel = hiltViewModel()
            ScannerScreen(
                viewModel = viewModel,
                back = { navController.popBackStack() }
            )
        }
    }
}

@Serializable
data object Top

@Serializable
data object Scanner

