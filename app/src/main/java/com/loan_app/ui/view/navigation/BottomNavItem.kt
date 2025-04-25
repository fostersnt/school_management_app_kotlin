package com.loan_app.ui.view.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String // For navigation
)

object BottomNavItems {
    val list = listOf(
        BottomNavItem(
            title = "Home",
            icon = Icons.Filled.Home,
            route = "home"
        ),
        BottomNavItem(
            title = "Profile",
            icon = Icons.Filled.Person,
            route = "profile"
        ),
        BottomNavItem(
            title = "Settings",
            icon = Icons.Filled.Settings,
            route = "settings"
        )
    )
}
