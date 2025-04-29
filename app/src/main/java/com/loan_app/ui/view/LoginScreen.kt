package com.loan_app.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.loan_app.ui.view.components.CustomButton
import com.loan_app.ui.view.components.CustomOutlinedTextField
import com.loan_app.ui.viewmodel.LoginViewModel
import com.loan_app.R

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

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF262053))
            .padding(20.dp),
    ) {
        Text(
            text = "Get started with your phone number",
//            text = "laboriosam",
            style = MaterialTheme.typography.titleLarge,
        )
        //Adding space
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        //Input field
        CustomOutlinedTextField(
            "",
            { LeadingContentItem() },
            viewModel.msisdn,
            {viewModel.onMsisdnChanged(msisdnData.value.toString())}
        )
        //Space
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        //
        CustomButton("Send OTP", 20, 1f, {viewModel.otpTrigger()})
    }
}

@Composable
fun LeadingContentItem(){
    Text(
        text = "+233 |",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(10.dp),
    )
}