package com.rcl.app

import androidx.compose.ui.graphics.vector.ImageVector
import com.rcl.base.RootComponent

data class Routes(
    val name: String,
    val configuration: RootComponent.Configuration,
    val outlinedIcon: ImageVector,
    val filledIcon: ImageVector,
)