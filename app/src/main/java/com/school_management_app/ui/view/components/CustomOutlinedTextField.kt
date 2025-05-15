package com.school_management_app.ui.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData

@Composable
fun CustomOutlinedTextField(
    label: String,
    leadingContent: @Composable () -> Unit,
    stateVariable: MutableLiveData<String>,
    onValueChange: (String) -> Unit
){
//    val stateData = rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        label = { Text(text = label) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
//            .padding(start = 10.dp, top = 20.dp, bottom = 20.dp, end = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0XFFFFFFFF),
            unfocusedContainerColor = Color(0XFFE5E5F0),
            focusedPlaceholderColor = Color(0xFFEB5757),
            unfocusedBorderColor = Color(0xFF4A148C)
        ),
        value = "${stateVariable.value}",
        onValueChange = {
            input ->
            stateVariable.value = input
            onValueChange("${stateVariable.value}")
                        },
        leadingIcon = {leadingContent()},
        textStyle = MaterialTheme.typography.labelMedium,
//        textStyle = TextStyle(
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold
//        )
    )
}

//@Composable
//fun LeadingContentItem(){
//    Text(
//        text = "TEST |",
//        fontSize = 20.sp,
//        fontWeight = FontWeight.Bold,
//        modifier = Modifier.padding(10.dp),
//    )
//}

//@Preview(showBackground = true)
//@Composable
////fun ShowCustomOutlinedTextField(){
////    val viewModel: LoginViewModel = viewModel();
////    CustomOutlinedTextField(
////        "",
////        { LeadingContentItem() },
////        viewModel.getMsisdn(),
////        {}
////    )
////}