package com.loan_app.ui.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
//        .fillMaxHeight(0.8f)
        .background(
            Color(0xFF262053)
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            //Text ----------------
            Text(
                text = "Get started with your phone number",
                style = TextStyle(
                color = Color.White,
                fontSize = 30.sp,
                    textAlign = TextAlign.Center
                ),
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight(0.5f)
            ) {
                //Input field --------------
                OutlinedTextField(
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color(0XFFFFFFFF),
                        unfocusedContainerColor = Color(0XFFE5E5F0),
                        focusedPlaceholderColor = Color(0xFFEB5757)
                    ),
                    value = "${msisdnData.value}",
                    onValueChange = { input -> viewModel.onMsisdnChanged(input) },
                    leadingIcon = {
                        Text(
                            text = "+233 |",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(10.dp),
                        )
                    },
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                    )
                )
                //Button ----------
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF3A39FF)
                    ),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { Log.i("LoginScreen", "LoginScreen: ")},
                    content = { Text(text = "Send OTP", modifier = Modifier.padding(20.dp)) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}