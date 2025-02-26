package com.mokelab.demo.android16.feature.verticaltext

import android.graphics.Paint
import android.graphics.Paint.VERTICAL_TEXT_FLAG
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.sp
import com.mokelab.demo.android16.core.design.component.HasBackTopAppBar
import com.mokelab.demo.android16.core.design.component.MediumText
import com.mokelab.demo.android16.core.design.component.Screen

@Composable
fun VerticalTextScreen(
    back: () -> Unit,
) {
    Screen(
        topBar = {
            HasBackTopAppBar(
                title = { MediumText("Vertical Text") },
                back = back,
            )
        },
    ) { innerPadding ->
        val text = "「春は、曙。」\n改行"
        Box(
            Modifier
                .padding(innerPadding)
                .background(Color.White)
                .fillMaxSize()
                .drawWithContent {
                    drawIntoCanvas { canvas ->
                        val paint = Paint().apply { textSize = 64.sp.toPx() }
                        // Draw text vertically
                        paint.flags = paint.flags or VERTICAL_TEXT_FLAG
                        val height = paint.measureText(text)
                        canvas.nativeCanvas.drawText(
                            text,
                            0,
                            text.length,
                            size.width / 2,
                            (size.height - height) / 2,
                            paint
                        )
                    }
                }
        ) {}
    }
}
