package com.loan_app.ui.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loan_app.utilities.customFontFamily

@Composable
fun CustomButton(buttonText: String, paddingValue: Int, btnWidth: Float, btnAction: () -> Unit){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF3A39FF)
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = { btnAction() },
        content = {
            Text(
                text = buttonText,
//                modifier = Modifier.padding(paddingValue.dp),
//                fontFamily = customFontFamily(),
//                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        },
        modifier = Modifier.fillMaxWidth(btnWidth)
    )
}

@Preview(showBackground = true)
@Composable
fun ShowCustomButton(){
    CustomButton("Hello", 20, 1f, {})
}