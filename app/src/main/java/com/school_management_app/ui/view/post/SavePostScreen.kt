package com.school_management_app.ui.view.post

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.school_management_app.ui.viewmodel.PostViewModel

@Composable
fun SavePostScreen(viewModel: PostViewModel) {
    var url = remember { mutableStateOf("") }
    var title = remember { mutableStateOf("") }
    var content = remember { mutableStateOf("") }

    Column {
        TextField(value = "title", onValueChange = { title.value = it }, label = { Text("Name") })
        TextField(value = "content", onValueChange = { content.value = it }, label = { Text("Email") })

        Button(onClick = { viewModel.createPost(url.value, title.value, content.value) }) {
            Text("Submit")
        }
    }
}
