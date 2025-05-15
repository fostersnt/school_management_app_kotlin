package com.school_management_app.ui.view.post

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import com.school_management_app.ui.viewmodel.PostViewModel
import androidx.compose.runtime.getValue

@Composable
    fun AllPostsScreen(viewModel: PostViewModel) {
        LaunchedEffect(Unit) { viewModel.fetchPosts() }
        val posts by viewModel.posts.observeAsState(emptyList())
//        val posts: List<PostPostData> = viewModel.posts

        LazyColumn {
            items(posts) { post ->
                Text("${post.title} - ${post.content}")
            }
        }
    }