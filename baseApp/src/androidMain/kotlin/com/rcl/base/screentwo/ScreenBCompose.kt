package com.rcl.base.screentwo

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ScreenBCompose(screenBComponent: ScreenBComponent) {
    val text = screenBComponent.text

    Text(text)
}