package com.example.circular_progress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgress(percentage: Float, number: Int, fontSize: TextUnit = 28.sp, radius: Dp, color: Color,strokeWidth:Dp, animationDuration: Int = 1000, animationDelay: Int = 0){
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed){
            percentage
        }else{
            0f
        },
        label = "",
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )
    LaunchedEffect(key1 = true, block = {
        animationPlayed = true
    })

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(
            modifier = Modifier.size(radius * 2f),
            onDraw ={
                drawArc(
                    color = color,
                    -90f,
                    360 * curPercentage.value,
                    useCenter = false,
                    style = Stroke(
                        strokeWidth.toPx(), cap = StrokeCap.Round
                    )
                )
            }
        )
        Text(text = (curPercentage.value * number).toInt().toString(), fontSize = fontSize, color = Color.Black, fontWeight = FontWeight.Bold)
    }
}