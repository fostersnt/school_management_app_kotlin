package com.loan_app.ui.view.post

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.loan_app.ui.viewmodel.PostViewModel

@Composable
fun SavePostScreen(viewModel: PostViewModel) {
    var title = remember { mutableStateOf("") }
    var content = remember { mutableStateOf("") }

    Column {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })

        Button(onClick = { viewModel.(name, email) }) {
            Text("Submit")
        }
    }
}
