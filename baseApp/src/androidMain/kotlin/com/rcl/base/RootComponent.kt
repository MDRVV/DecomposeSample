package com.rcl.base

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.rcl.base.screenone.ScreenAComponent
import com.rcl.base.screenthree.ScreenCComponent
import com.rcl.base.screentwo.ScreenBComponent
import kotlinx.serialization.Serializable

class RootComponent(context: ComponentContext) : ComponentContext by context {
    private val navigator = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigator,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.ScreenA,
        handleBackButton = true,
        childFactory = ::createChild
    )

    fun navigateTo(config: Configuration) {
        navigator.bringToFront(config)
    }

    fun onBack() {
        navigator.pop()
    }

    private fun createChild(
        config: Configuration,
        context: ComponentContext,
    ): Child {
        return when (config) {
            Configuration.ScreenA -> Child.ScreenA(
                ScreenAComponent()
            )
            Configuration.ScreenB -> Child.ScreenB(
                ScreenBComponent()
            )
            Configuration.ScreenC -> Child.ScreenC(
                ScreenCComponent()
            )
        }
    }

    sealed class Child {
        data class ScreenA(val component: ScreenAComponent) : Child()
        data class ScreenB(val component: ScreenBComponent) : Child()
        data class ScreenC(val component: ScreenCComponent) : Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object ScreenA : Configuration()


        @Serializable
        data object ScreenB : Configuration()

        @Serializable
        data object ScreenC : Configuration()
    }
}