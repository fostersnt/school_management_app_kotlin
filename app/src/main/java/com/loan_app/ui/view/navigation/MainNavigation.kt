package com.loan_app.ui.view.navigation


import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        topBar = {
            if (currentRoute !in bottomNavRoutes) {
                TopAppBar(
                    modifier = Modifier.statusBarsPadding(),
                    backgroundColor = Color.White,
                    title = { Text("") },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigateUp()
                        }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xFFff3779))
                        }
                    }
                )
            }
        },
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