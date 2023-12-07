package com.rcl.app

import android.app.assist.AssistContent
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.core.view.WindowCompat
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.predictiveback.predictiveBackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.arkivanov.decompose.retainedComponent
import com.rcl.app.MatTheme.AppTheme
import com.rcl.app.Screens.screens
import com.rcl.base.RootComponent
import com.rcl.base.screenone.ScreenACompose
import com.rcl.base.screenthree.ScreenCCompose
import com.rcl.base.screentwo.ScreenBCompose

class AppActivity : ComponentActivity() {
    override fun onProvideAssistContent(outContent: AssistContent) {
        super.onProvideAssistContent(outContent)

    }

    @OptIn(ExperimentalDecomposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val root = retainedComponent {
            RootComponent(it)
        }
        setContent {
            App(root)
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
    }

    @Composable
    fun App(root: RootComponent) = AppTheme {
        NavBar(root)
    }

    @OptIn(ExperimentalDecomposeApi::class)
    @Composable
    fun NavBar(rootComponent: RootComponent) {
        val stack by rootComponent.childStack.subscribeAsState()
        Scaffold(
            content = { paddings ->
                Box(modifier = Modifier.padding(paddings)) {
                    Children(
                        stack = stack,
                        animation = predictiveBackAnimation(
                            backHandler = rootComponent::backHandler.get(),
                            onBack = {
                                rootComponent.onBack()
                            },
                        ),
                    ) { child ->
                        when (val instance = child.instance) {
                            is RootComponent.Child.ScreenA -> ScreenACompose(instance.component)
                            is RootComponent.Child.ScreenB -> ScreenBCompose(instance.component)
                            is RootComponent.Child.ScreenC -> ScreenCCompose(instance.component)
                        }
                    }
                }
            },
            bottomBar = {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.background
                ) {
                    screens.forEach { item ->
                        val selected = stack.active.configuration == item.configuration
                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                rootComponent.navigateTo(item.configuration)
                            },
                            label = {
                                Text(
                                    text = item.name,
                                    fontWeight = FontWeight.SemiBold,
                                )
                            },
                            icon = {
                                Icon(
                                    imageVector = if (selected) {
                                        item.filledIcon
                                    } else {
                                        item.outlinedIcon
                                    },
                                    contentDescription = "Icon",
                                )
                            },
                            alwaysShowLabel = false
                        )
                    }
                }
            }
        )
    }
}