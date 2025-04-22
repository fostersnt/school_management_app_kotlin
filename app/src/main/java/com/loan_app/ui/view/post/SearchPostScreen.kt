package com.loan_app.ui.view.post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.loan_app.ui.viewmodel.PostViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun SearchPostScreen(viewModel: PostViewModel) {
    var query by remember { mutableStateOf("") }
    val searchResults by viewModel.searchResults.observeAsState(emptyList())

    Column {
        TextField(value = query, onValueChange = { query = it }, label = { Text("Search") })

        Button(onClick = { viewModel.searchPost(query) }) {
            Text("Search")
        }

        LazyColumn {
            items(searchResults.count()) { post ->
                Text("${post} - ${post}")
            }
        }
    }
}
