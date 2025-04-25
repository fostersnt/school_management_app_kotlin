package com.loan_app.ui.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.loan_app.ui.viewmodel.LoginViewModel
import java.util.Objects

@Composable
fun CustomOutlinedTextField(
    label: String,
    leadingContent: @Composable () -> Unit,
    data: LiveData<String>,
    onValueChange: (String) -> Unit
){
    OutlinedTextField(
        label = { Text(text = label) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(start = 10.dp, top = 20.dp, bottom = 20.dp, end = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0XFFFFFFFF),
            unfocusedContainerColor = Color(0XFFE5E5F0),
            focusedPlaceholderColor = Color(0xFFEB5757)
        ),
        value = "${data.value}",
        onValueChange = { input: String -> onValueChange(input) },
        leadingIcon = {leadingContent()},
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    )
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

@Preview(showBackground = true)
@Composable
fun ShowCustomOutlinedTextField(){
    val viewModel: LoginViewModel = viewModel();
    CustomOutlinedTextField(
        "",
        { LeadingContentItem() },
        viewModel.getMsisdn(),
        {}
    )
}