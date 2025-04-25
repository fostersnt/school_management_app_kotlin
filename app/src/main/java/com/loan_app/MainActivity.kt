package com.loan_app

import android.os.Bundle
//import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
//import androidx.hilt.navigation.compose.hiltViewModel
import com.loan_app.data.repository.PostRepository
import com.loan_app.ui.view.LoginScreen
import com.loan_app.ui.view.navigation.MainHomeScreen
import com.loan_app.ui.viewmodel.PostViewModel
//import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val postViewModel by lazy { PostViewModel(PostRepository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//                    InitialScreen()
        MainHomeScreen()
//            Surface(modifier = Modifier.fillMaxSize().fillMaxWidth().fillMaxHeight()) {
//                Column(modifier = Modifier.fillMaxSize()) {
////                SinglePostScreen(postViewModel, 1)
////                AllPostsScreen(postViewModel)
////                SavePostScreen(postViewModel)
////                SearchPostScreen(postViewModel)
//                }
//            }
        }
    }
}

//@Composable
//fun (name: String, modifier: Modifier = Modifier) {
//    LoginScreen()
//}

@Preview(showBackground = true)
@Composable
fun InitialScreen() {
//    Loan_AppTheme {
    Surface(modifier = Modifier.fillMaxSize()) {
        LoginScreen()
    }
//    }
}