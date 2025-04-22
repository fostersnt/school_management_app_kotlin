package com.loan_app.ui.view.post

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import com.loan_app.ui.viewmodel.PostViewModel

@Composable
fun SinglePostScreen(viewModel: PostViewModel, postId: Int) {
    LaunchedEffect(Unit) { viewModel.fetchPost(postId) }
    val post = viewModel.post.observeAsState()

//    post?.let {
        Text("Name: ${post.value?.title}")
        Text("Email: ${post.value?.content}")
//    } ?: Text("Loading...")
}
