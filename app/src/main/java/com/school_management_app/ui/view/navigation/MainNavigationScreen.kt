package com.school_management_app.ui.view.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
//import com.loan_app.Manifest
import com.school_management_app.data.model.AppRoutes


@Composable
fun MainNavigationScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBar = currentRoute in listOf(
        AppRoutes.HOME_SCREEN,
        AppRoutes.PROFILE_SCREEN,
        AppRoutes.SETTINGS_SCREEN
    )

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(navController = navController, currentRoute)
            }
        }
    ) { paddingValues ->
        NavigationGraph(navController = navController, paddingValues = paddingValues)
//        BottomNavigationBar(navController = navController, paddingValues = paddingValues)
    }
}