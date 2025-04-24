package com.loan_app

import android.os.Bundle
import android.util.Log
//import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
//import androidx.hilt.navigation.compose.hiltViewModel
import com.loan_app.data.repository.PostRepository
import com.loan_app.ui.theme.Loan_AppTheme
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
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            Loan_AppTheme {
//                Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }

            Column {
                SinglePostScreen(postViewModel, 1)
//                AllPostsScreen(postViewModel)
                SavePostScreen(postViewModel)
                SearchPostScreen(postViewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.clickable { Log.i("TAG", "Welcome: $name!") },
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Loan_AppTheme {
        Greeting("Android")
    }
}