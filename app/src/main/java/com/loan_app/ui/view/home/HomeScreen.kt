package com.loan_app.ui.view.home

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loan_app.utilities.customFontFamily

@Preview(showBackground = true)
@Composable

fun HomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
        .background(Color(0xFFff3779))
        .padding(top = 80.dp)
        .clip(RoundedCornerShape(16.dp)) // Apply rounded corners
        .background(Color.White)      // Background to make it visible
        .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.End),
//            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Hi Foster",
                style = TextStyle(
                    fontFamily = customFontFamily(),
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp
                )
            )
        }
        //FIRST CARD
        Card(
            modifier = Modifier.fillMaxWidth()
                .height(200.dp)
                .align(
                    alignment = Alignment.Start
                ),
//            colors = CardDefaults.cardColors(containerColor = Color.Green),
//            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp,
                pressedElevation = 6.dp
            )
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFff3779)),
//                    .background(Color(0xFF0d0551)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Wallet Balance",
                    fontFamily = customFontFamily(),
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                Text(
                    "GHs 5,000.00",
                    style = TextStyle(
                        fontFamily = customFontFamily(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.White
                    )
                )
            }
        }
        //SECOND GROUP OF CARDS
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Card(
            modifier = Modifier.fillMaxWidth()
                .height(150.dp)
                .align(
                    alignment = Alignment.Start
                ),
//            colors = CardDefaults.cardColors(containerColor = Color.Green),
//            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp,
                pressedElevation = 6.dp
            )
        ){
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.background(Color(0xFFff3779))
                        .weight(0.3f)
                        .fillMaxHeight()
                ) {  }
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Column(
                    modifier = Modifier.background(Color(0xFFff3779))
                        .weight(0.3f)
                        .fillMaxHeight()
                ) {  }
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Column(
                    modifier = Modifier.background(Color(0xFFff3779))
                        .weight(0.3f)
                        .fillMaxHeight()
                ) {  }
            }
        }
    }
}