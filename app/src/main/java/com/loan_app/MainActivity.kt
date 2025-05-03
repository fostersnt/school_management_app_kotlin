package com.loan_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.loan_app.data.local.repository.PostRepository
import com.loan_app.ui.theme.Loan_AppTheme
import com.loan_app.ui.view.navigation.BottomNavigationBar
import com.loan_app.ui.view.navigation.NavigationGraph
import com.loan_app.ui.viewmodel.PostViewModel

class MainActivity : ComponentActivity() {
    private val postViewModel by lazy { PostViewModel(PostRepository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController();
            Loan_AppTheme {
//                BottomNavigationBar(navController)
                NavigationGraph(navController, paddingValues = PaddingValues());
            }
        }
    }
}