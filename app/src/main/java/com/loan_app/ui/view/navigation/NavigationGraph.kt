package com.loan_app.ui.view.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.loan_app.ui.view.LoginScreen
import com.loan_app.ui.view.home.HomeScreen
import com.loan_app.ui.view.loan.LoanRequestScreen


@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = "home") {
            HomeScreen(navController = navController)
        }
        composable(route = "loan_request") {
            LoanRequestScreen(navController = navController)
        }
        composable(route = "profile") {
            LoginScreen(navController = navController)
        }
        composable(route = "settings") {
            LoginScreen(navController = navController)
        }
        composable(route = "Loans") {
            LoginScreen(navController = navController)
        }
        // Add other routes as needed
    }
}
