package com.loan_app.ui.view.post

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.loan_app.ui.viewmodel.PostViewModel

@Composable
fun SinglePostScreen(viewModel: PostViewModel, postId: Int) {
    LaunchedEffect(Unit) { viewModel.fetchUser(postId) }
    val post = viewModel.post

//    post?.let {
        Text("Name: ${it.name}")
        Text("Email: ${it.email}")
//    } ?: Text("Loading...")
}
