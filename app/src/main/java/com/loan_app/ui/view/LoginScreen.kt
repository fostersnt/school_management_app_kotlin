package com.loan_app.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.loan_app.ui.viewmodel.LoginViewModel

@Preview(showBackground = true)
@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF262053)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = viewModel.msisdn.value,
//            onValueChange = viewModel::onMsisdnChanged, //input -> viewModel.onMsisdnChanged(input
            onValueChange = { input -> viewModel.onMsisdnChanged(input) },
            label = { Text("Phone Number") }
        )
    }
}