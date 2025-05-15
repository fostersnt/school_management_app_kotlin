package com.school_management_app.ui.view.user

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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.school_management_app.ui.viewmodel.LoginViewModel

//@Preview(showBackground = true)
@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel(), navController: NavController){
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
//        .background(Color(0xFF262053))
            .background(brush = Brush.linearGradient(
                colors = listOf(Color(0xFFff3779), Color(0xFF007298)),
//                colors = listOf(Color(0xFFff3779), Color(0xFF0d0551)),
//                colors = listOf(Color.Red, Color(0xFF262053)),
//                colors = listOf(Color(0xFF42A5F5), Color(0xFF262053)),
//                start = Offset(500f, 500f), //NICE ONE
//                end = Offset(1000f, 1000f),
//                start = Offset(300f, 200f),
//                end = Offset(1000f, 1000f)
                start = Offset(600f, 900f),
                end = Offset(1000f, 1000f)
            ))
            .padding(20.dp),
    ) {
        Text(
            text = "Get started with your phone number",
            style = MaterialTheme.typography.headlineLarge,
        )
        //Adding space
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        //Input field
//        CustomOutlinedTextField(
//            "",
//            { LeadingContentItem() },
//            viewModel.msisdn,
//            {viewModel.onMsisdnChanged(msisdnData.value.toString())}
//        )
        //Space
        Spacer(modifier = Modifier.padding(bottom = 20.dp))
        //
//        CustomButton("Send OTP", 20, 1f, {viewModel.otpTrigger()})
    }
}

@Composable
fun LeadingContentItem(){
    Text(
        text = "+233 |",
        style = MaterialTheme.typography.labelMedium,
        modifier = Modifier.padding(10.dp),
    )
}