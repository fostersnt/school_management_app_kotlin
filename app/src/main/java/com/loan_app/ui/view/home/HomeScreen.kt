package com.loan_app.ui.view.home

import android.text.Layout
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loan_app.utilities.customFontFamily
import com.loan_app.R

@Preview(showBackground = true)
@Composable
fun HomeScreen(){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    val columnHeight = (screenHeight - (0.1 * screenHeight)) / 3;

    Column(
        modifier = Modifier.fillMaxSize()
        .background(Color(0xFFff3779))
        .padding(top = 80.dp)
        .clip(RoundedCornerShape(16.dp)) // Apply rounded corners
        .background(Color.White)      // Background to make it visible
        .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.Start).padding(bottom = 10.dp),
//            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Hi Foster",
                style = TextStyle(
                    fontFamily = customFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            )
        }
        //FIRST CARD
        Card(
            modifier = Modifier.fillMaxWidth()
                .height(columnHeight.dp)
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
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height((columnHeight - (0.1 * columnHeight)).dp)
            ) {
                Column(
                    modifier = Modifier.background(Color.White)
                        .weight(0.25f)
                        .fillMaxHeight()
                        .clip(shape = RoundedCornerShape(20.dp))
//                        .fillMaxWidth()
                        .background(Color(0xFFff3779))
                        .padding(10.dp)  // Inner padding
                        .height(columnHeight.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.card_1_image),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .width(80.dp)
                            .height(80.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = "Apply Loan", style = MaterialTheme.typography.bodyLarge)
                }
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Column(
                    modifier = Modifier.background(Color.White)
                        .weight(0.25f)
                        .fillMaxHeight()
                        .clip(shape = RoundedCornerShape(20.dp))
//                        .fillMaxWidth()
                        .background(Color(0xFFff3779))
                        .padding(10.dp),  // Inner padding
//                        .height(columnHeight.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.card_2_image),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .width(80.dp)
                            .height(80.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = "Loan History", style = MaterialTheme.typography.bodyLarge)
                }
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Column(
                    modifier = Modifier.background(Color.White)
                        .weight(0.25f)
                        .fillMaxHeight()
                        .clip(shape = RoundedCornerShape(20.dp))
//                        .fillMaxWidth()
                        .background(Color(0xFFff3779))
                        .padding(10.dp),  // Inner padding
//                        .height(200.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.card_3_image),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .width(80.dp)
                            .height(80.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = "My Account", style = MaterialTheme.typography.bodyLarge)
                }
        }
        //LAST CARD
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Card(
            modifier = Modifier.fillMaxWidth()
                .height((columnHeight / 2).dp)
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
    }
}