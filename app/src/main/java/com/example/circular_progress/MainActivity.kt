package com.example.circular_progress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.circular_progress.ui.theme.Circular_progressTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Circular_progressTheme {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        //CircularProgress(radius = 50.dp, color = Color.Green, number = 100, percentage = 0.9f, strokeWidth = 10.dp)
                        DigramProgress(
                            height1 = 300.dp,
                            height2 = 240.dp,
                            height3 = 200.dp,
                            width = 100.dp,
                            color = Color.Magenta,
                            strokeWidth = 4.dp
                        )
                    }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Circular_progressTheme {
        CircularProgress(radius = 50.dp, color = Color.Green, number = 100, percentage = 0.8f, strokeWidth = 10.dp)
    }
}