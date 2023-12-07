package com.rcl.app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import com.rcl.base.RootComponent

object Screens {
    val screens = listOf(
        Routes(
            name = "ScreenA",
            configuration = RootComponent.Configuration.ScreenA,
            outlinedIcon = Icons.Outlined.Home,
            filledIcon = Icons.Filled.Home
        ),
        Routes(
            name = "ScreenB",
            configuration = RootComponent.Configuration.ScreenB,
            outlinedIcon = Icons.Outlined.Search,
            filledIcon = Icons.Filled.Search
        ),
        Routes(
            name = "ScreenC",
            configuration = RootComponent.Configuration.ScreenC,
            outlinedIcon = Icons.Outlined.AccountCircle,
            filledIcon = Icons.Filled.AccountCircle
        )
    )
}