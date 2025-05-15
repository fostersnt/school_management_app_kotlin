package com.school_management_app.ui.view.post

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import com.school_management_app.ui.viewmodel.PostViewModel

@Composable
fun SinglePostScreen(viewModel: PostViewModel, postId: Int) {
        LaunchedEffect(Unit) { viewModel.fetchPost(postId) }
        val post = viewModel.post.observeAsState().value

//    Log.i("SinglePostScreen", "$post?.let { post.title }")

        if (post != null){
            Text("Name: ${post.title}")
            Text("Email: ${post.content}")
        }else{
            Text("Loading...")
        }
}
