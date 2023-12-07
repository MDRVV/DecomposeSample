package com.rcl.base.screenone

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun ScreenACompose(screenAComponent: ScreenAComponent) {
    val counter by screenAComponent.counter.subscribeAsState()

    Column {
        Text(text = counter.toString())
        Button(onClick = { screenAComponent.increment() }) {
            Text("increment")
        }
        Button(onClick = { screenAComponent.decrement() }) {
            Text("decrement")
        }
    }
}