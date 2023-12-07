package com.rcl.base.screenthree

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun ScreenCCompose(screenCComponent: ScreenCComponent) {
    val str by screenCComponent.text.subscribeAsState()

    Column {
        TextField(
            value = str,
            onValueChange = { str ->
                screenCComponent.onSearchChanged(str)
            }
        )
        Text(text = str)
    }
}