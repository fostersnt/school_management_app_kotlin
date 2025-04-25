package com.loan_app.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.loan_app.ui.viewmodel.LoginViewModel

@Preview(showBackground = true)
@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()){
//fun LoginScreen(viewModel: LoginViewModel = viewModel()){
    /*
    This line below observes the msisdn state variable defined inside the LoginViewModel. It will cause
    the ui/view to be re-build any time the state value changes inside the LoginViewModel
    */
viewModel.msisdn.observeAsState().value;

    /*
    The line below retrieves the state msisdn value from the LoginViewModel in form that cannot be
    changed in the view.

    NOTE: Changes to state variable must occur only in the view model
    */
val msisdnData = viewModel.getMsisdn();

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF262053)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0XFFFFFFFF),     // background when focused
                unfocusedContainerColor = Color(0XFFE5E5F0),   // background when not focused
//                focusedTextColor = Color(0xFFEB5757),
                focusedPlaceholderColor = Color(0xFFEB5757)
//                unfocusedTextColor = Color.Green
            ),
            value = "${msisdnData.value}",
//            onValueChange = viewModel::onMsisdnChanged, //input -> viewModel.onMsisdnChanged(input
            onValueChange = { input -> viewModel.onMsisdnChanged(input) },
//            label = { Text("Phone Number") },
            leadingIcon = {
                Text(text = "+233 |")
            },
            textStyle = TextStyle(
                color = Color.Green,
                fontSize = 20.sp
            )
        )
    }
}