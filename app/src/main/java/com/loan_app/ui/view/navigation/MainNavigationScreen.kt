package com.loan_app.ui.view.navigation

import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.firebase.FirebaseApp
//import com.loan_app.Manifest
import com.loan_app.data.model.AppRoutes
import com.loan_app.utilities.FirebaseTokenManager



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