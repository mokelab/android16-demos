package com.mokelab.demo.android16.feature.optout16kb

import androidx.camera.compose.CameraXViewfinder
import androidx.camera.core.SurfaceRequest
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.mokelab.demo.android16.core.design.component.HasBackTopAppBar
import com.mokelab.demo.android16.core.design.component.MediumText
import com.mokelab.demo.android16.core.design.component.Screen

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ScannerScreen(
    viewModel: ScannerViewModel,
    back: () -> Unit,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val surfaceRequest by viewModel.surfaceRequest.collectAsStateWithLifecycle()

    val permissionState = rememberPermissionState(android.Manifest.permission.CAMERA)
    if (permissionState.status.isGranted) {
        LaunchedEffect(lifecycleOwner) {
            viewModel.bindToCamera(lifecycleOwner)
        }

        ScannerScreen(
            back = back,
            surfaceRequest = surfaceRequest,
        )
        return
    }
    if (permissionState.status.shouldShowRationale) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            MediumText(stringResource(R.string.camera_permission_required))
        }
        return
    }
    LaunchedEffect(Unit) {
        permissionState.launchPermissionRequest()
    }
}

@Composable
private fun ScannerScreen(
    back: () -> Unit,
    surfaceRequest: SurfaceRequest?,
) {
    Screen(
        topBar = {
            HasBackTopAppBar(
                title = { MediumText("Scanner") },
                back = back,
            )
        }
    ) { innerPadding ->
        surfaceRequest?.let {
            CameraXViewfinder(
                surfaceRequest = it,
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}