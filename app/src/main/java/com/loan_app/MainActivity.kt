package com.loan_app

import android.os.Bundle
import android.util.Log
//import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.loan_app.data.model.Post
//import androidx.hilt.navigation.compose.hiltViewModel
import com.loan_app.data.repository.PostRepository
import com.loan_app.ui.theme.Loan_AppTheme
import com.loan_app.ui.view.LoginScreen
import com.loan_app.ui.view.home.MainHomeScreen
import com.loan_app.ui.view.post.AllPostsScreen
import com.loan_app.ui.view.post.SavePostScreen
import com.loan_app.ui.view.post.SearchPostScreen
import com.loan_app.ui.view.post.SinglePostScreen
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