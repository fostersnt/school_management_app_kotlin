package com.loan_app.ui.view.post

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.loan_app.data.model.PostPostData
import com.loan_app.ui.viewmodel.PostViewModel

@Composable
    fun AllPostsScreen(viewModel: PostViewModel) {
        LaunchedEffect(Unit) { viewModel.fetchUsers() }
        val posts: List<PostPostData> = viewModel.posts

        LazyColumn {
            items(posts.count()) { post ->
//                Text("${post.title} - ${post.content}")
            }
        }
    }