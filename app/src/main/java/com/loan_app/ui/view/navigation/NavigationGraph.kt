package com.loan_app.ui.view.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.loan_app.ui.view.user.LoginScreen
import com.loan_app.ui.view.home.HomeScreen
import com.loan_app.ui.view.loan.LoanRequestScreen
import com.loan_app.ui.view.user.ProfileScreen
import com.loan_app.ui.view.user.SettingsScreen
import com.loan_app.ui.view.user.TestScreen
import com.loan_app.ui.viewmodel.LoanRequestViewModel


@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.bottom_navigation_screen,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = AppRoutes.login_screen) {
            LoginScreen(navController = navController)
        }
        composable(route = AppRoutes.home_screen) {
            HomeScreen(navController = navController)
        }
        composable(route = AppRoutes.bottom_navigation_screen) {
            BottomNavigationBar(navController = navController)
        }
        composable(route = AppRoutes.loan_request_screen) {
            LoanRequestScreen(navController = navController)
        }
        composable(route = AppRoutes.profile_screen) {
            ProfileScreen(navController)
        }
        composable(route = AppRoutes.settings_screen) {
            SettingsScreen(navController)
        }
        composable(route = AppRoutes.test_screen) {
            TestScreen(navController)
        }
    }
}
