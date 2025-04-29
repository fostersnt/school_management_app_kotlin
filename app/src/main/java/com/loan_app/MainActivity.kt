package com.loan_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.loan_app.data.local.repository.PostRepository
import com.loan_app.ui.theme.Loan_AppTheme
import com.loan_app.ui.view.LoginScreen
import com.loan_app.ui.viewmodel.PostViewModel

class MainActivity : ComponentActivity() {
    private val postViewModel by lazy { PostViewModel(PostRepository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Loan_AppTheme {
                LoginScreen()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun InitialScreen() {
        LoginScreen()
}