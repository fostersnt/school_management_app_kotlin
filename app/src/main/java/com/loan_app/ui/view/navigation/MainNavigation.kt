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
            // Show a back button only if the current route is not a bottom tab
            if (currentRoute !in bottomNavRoutes) {
                TopAppBar(
                    modifier = Modifier.statusBarsPadding(),
                    title = { Text("App Title") },
                    navigationIcon = {
                        IconButton(onClick = {
                            // Handle the back navigation
                            navController.navigateUp() // This will pop the current screen and show the previous one
                        }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
//                Spacer(modifier = Modifier.height(20.dp))
//                Card(
//                    modifier = Modifier.padding(20.dp)
//                        .fillMaxWidth()
//                        .height(40.dp),
//                    colors = CardDefaults.cardColors(
//                        containerColor = Color.White
//                    )
//                ) {
//                    Row {
//                        Text(text = "ABCD")
//                        Text(text = "ABCD")
//                    }
//                }
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