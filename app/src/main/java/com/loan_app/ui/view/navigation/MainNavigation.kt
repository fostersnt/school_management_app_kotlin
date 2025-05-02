package com.loan_app.ui.view.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    // Keep track of the current route
//    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentBackStackEntry = navController.currentBackStackEntryAsState().value

    val currentRoute = currentBackStackEntry?.destination?.route

    // Define the start destination and routes that require bottom navigation
    val bottomNavRoutes = listOf("home", "profile", "settings")

    Scaffold(
        bottomBar = {
            if (currentRoute in bottomNavRoutes) {
                BottomNavigationBar(navController = navController) // Your Bottom Navigation Bar
            }
//            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavigationGraph(navController = navController, paddingValues = innerPadding)
    }
}