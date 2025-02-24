package com.mokelab.demo.android16.feature.vibrator

import android.os.Vibrator
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mokelab.demo.android16.core.design.component.HasBackTopAppBar
import com.mokelab.demo.android16.core.design.component.MediumText
import com.mokelab.demo.android16.core.design.component.Screen

@RequiresApi(36)
@Composable
fun VibratorScreen(
    back: () -> Unit,
) {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }

    Screen(
        topBar = {
            HasBackTopAppBar(
                title = { MediumText("Vibrator") },
                back = back
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
        ) {
            MediumText(text)
        }
    }


    LaunchedEffect(Unit) {
        var output = ""
        val vibrator = context.getSystemService(Vibrator::class.java)
        if (vibrator.areEnvelopeEffectsSupported()) {
            output += "Envelope effects are supported\n"
            val envelopeEffectInfo = vibrator.envelopeEffectInfo
            output += "\nMax size: ${envelopeEffectInfo.maxSize}\n"
            output += "\nminControlPointDurationMillis: ${envelopeEffectInfo.minControlPointDurationMillis}\n"
            output += "\nmaxDurationMillis: ${envelopeEffectInfo.maxDurationMillis}\n"
        } else {
            output += "Envelope effects are not supported\n"
        }
        output += "\n\n"

        val frequencyProfile = vibrator.frequencyProfile
        output += "Frequency profile\n"

        if (frequencyProfile == null) {
            output += "\nFrequency profile is null\n"
        } else {
            output += "\nminFrequency: ${frequencyProfile.minFrequencyHz}\n"
            output += "\nmaxFrequencyHz: ${frequencyProfile.maxFrequencyHz}\n"
            output += "\nmaxOutputAccelerationGs: ${frequencyProfile.maxOutputAccelerationGs}\n"
        }

        text = output
    }
}