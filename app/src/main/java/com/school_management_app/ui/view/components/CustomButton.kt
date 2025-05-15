package com.school_management_app.ui.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(buttonText: String, paddingValue: Int, btnWidth: Float, btnAction: () -> Unit){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF007298)
//            containerColor = Color(0xFF4A148C)
//            containerColor = Color(0xFF9B1FAE)
//            containerColor = Color(0xFF3A39FF)
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = { btnAction() },
        content = {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.labelLarge
            )
        },
        modifier = Modifier.fillMaxWidth(btnWidth)
            .height(80.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ShowCustomButton(){
    CustomButton("Hello", 20, 1f, {})
}