package com.example.circular_progress

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DigramProgress(height1: Dp, height2: Dp, height3: Dp, width: Dp, fontSize: TextUnit = 28.sp, color: Color, strokeWidth: Dp, animationDuration: Int = 1000, animationDelay: Int = 0){

    //UNCOMMENT THIS CODE FOR ANIMATION
        var animationPlayed by remember {
            mutableStateOf(false)
        }

        val height01Animated = animateDpAsState(
            targetValue = if (animationPlayed){
                height1
            }else{
                0.dp
            },
            label = "",
            animationSpec = tween(
                durationMillis = animationDuration,
                delayMillis = animationDelay
            )
        )

        val height02Animated = animateDpAsState(
            targetValue = if (animationPlayed){
                height2
            }else{
                0.dp
            },
            label = "",
            animationSpec = tween(
                durationMillis = animationDuration,
                delayMillis = animationDelay
            )
        )

        val height03Animated = animateDpAsState(
            targetValue = if (animationPlayed){
                height3
            }else{
                0.dp
            },
            label = "",
            animationSpec = tween(
                durationMillis = animationDuration,
                delayMillis = animationDelay
            )
        )

        LaunchedEffect(key1 = Unit, block = {
            animationPlayed = true
        })

    Row(modifier = Modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.Bottom) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.Blue)
                .height(height02Animated.value)
                .width(width)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRect(
                    color = color,
                    //topLeft = Offset(50f, 50f),
                    //size = Size(width, height),
                    style = Stroke(strokeWidth.toPx())
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.Blue)
                .height(height01Animated.value)
                .width(width)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRect(
                    color = color,
                    //topLeft = Offset(50f, 50f),
                    //size = Size(width,height),
                    style = Stroke(strokeWidth.toPx())
                )
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.Blue)
                .height(height03Animated.value)
                .width(width)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRect(
                    color = color,
                    //topLeft = Offset(50f, 50f),
                    //size = Size(width, height),
                    style = Stroke(strokeWidth.toPx())
                )
            }
        }
    }
}