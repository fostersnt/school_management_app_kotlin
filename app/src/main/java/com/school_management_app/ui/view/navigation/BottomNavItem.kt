package com.school_management_app.ui.view.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.school_management_app.data.model.AppRoutes

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
            route = AppRoutes.HOME_SCREEN
        ),
        BottomNavItem(
            title = "Profile",
            icon = Icons.Filled.Person,
            route = AppRoutes.PROFILE_SCREEN
        ),
        BottomNavItem(
            title = "Settings",
            icon = Icons.Filled.Settings,
            route = AppRoutes.SETTINGS_SCREEN
        )
    )
}
