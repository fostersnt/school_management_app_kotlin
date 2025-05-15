package com.loan_app.ui.view.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.loan_app.data.model.AppRoutes
import com.loan_app.ui.view.user.LoginScreen
import com.loan_app.ui.view.home.HomeScreen
import com.loan_app.ui.view.loan.LoanHistoryScreen
import com.loan_app.ui.view.loan.LoanRequestScreen
import com.loan_app.ui.view.student.AttendanceScreen
import com.loan_app.ui.view.user.ProfileScreen
import com.loan_app.ui.view.user.SettingsScreen
import com.loan_app.ui.view.user.TestScreen
import com.loan_app.ui.viewmodel.LoanRequestViewModel


@Composable
fun NavigationGraph(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.HOME_SCREEN,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(route = AppRoutes.LOGIN_SCREEN) {
            LoginScreen(navController = navController)
        }
        composable(route = AppRoutes.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }
//        composable(route = AppRoutes.BOTTOM_NAVIGATION_SCREEN) {
//            BottomNavigationBar(navController = navController)
//        }
        composable(route = AppRoutes.LOAN_REQUEST_SCREEN) {
            LoanRequestScreen(navController = navController)
        }
        composable(route = AppRoutes.PROFILE_SCREEN) {
            ProfileScreen(navController)
        }
        composable(route = AppRoutes.SETTINGS_SCREEN) {
            SettingsScreen(navController)
        }
        composable(route = AppRoutes.TEST_SCREEN) {
            TestScreen(navController)
        }
        composable(route = AppRoutes.LOAN_HISTORY_SCREEN) {
            LoanHistoryScreen(navController)
        }
        composable(route = AppRoutes.ATTENDANCE_SCREEN) {
            AttendanceScreen(navController)
        }
    }
}
