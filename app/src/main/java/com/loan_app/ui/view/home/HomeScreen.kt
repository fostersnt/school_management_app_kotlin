package com.loan_app.ui.view.home

import android.text.Layout
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.loan_app.utilities.customFontFamily
import com.loan_app.R

//@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavController){
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    val columnHeight = (screenHeight - (0.1 * screenHeight)) / 3;
    val miniCardWidth = ((screenWidth - (0.1 * screenWidth)) / 3) - 10; //20 represent the padding that has been applied to the main Column Container
    val scrollState = rememberScrollState();

//    val navController = rememberNavController();

    Column(
        modifier = Modifier
            .fillMaxSize()
//        .background(Color(0xFFff3779))
        .padding(20.dp)
//        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)) // Apply rounded corners
//        .background(Color(0xFFF9FBFB))      // Background to make it visible
//        .padding(10.dp)
            .verticalScroll(state = scrollState)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 10.dp),
//            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Hi Foster",
                style = TextStyle(
                    fontFamily = customFontFamily(),
                    fontWeight = FontWeight.Normal,
                    fontSize = 30.sp,
                )
            )
        }
        //FIRST CARD
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(columnHeight.dp)
                .align(
                    alignment = Alignment.Start
                ),
//            colors = CardDefaults.cardColors(containerColor = Color.Green),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
                pressedElevation = 10.dp
            )
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
//                    .border(
//                        width = 1.dp,
//                        color = Color(0xFFff3779),
//                        shape = RoundedCornerShape(10.dp)
//                    ),
//                    .background(Color(0xFF0d0551)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Loan Balance",
                    fontFamily = customFontFamily(),
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                Text(
                    "GHs 5,000.00",
                    style = TextStyle(
                        fontFamily = customFontFamily(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color(0xFFff3779)
                    )
                )
            }
        }
        //SECOND GROUP OF CARDS
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height((columnHeight / 2).dp)
                    .fillMaxWidth(1f)
            ) {
                Card(
                    modifier = Modifier
                        .width(miniCardWidth.dp)
                        .height(columnHeight.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 10.dp
                    ),
                    onClick = {
                        Log.i("HomeScreen", "Apply Loan is clicked")
                        navController.navigate("loan_request"){
                            // When navigating away from the Home screen, clear the back stack
//                            popUpTo("home") {
//                                inclusive = true // This makes sure the Home screen itself is cleared
//                            }
//                            launchSingleTop = true // Prevent multiple instances of the same screen
//                            restoreState = true // Restore the previous state when navigating back
                        };
                    }
                ){
                    Column(
                        modifier = Modifier
                            .background(Color.White)
//                            .weight(0.25f)
                            .fillMaxHeight()
//                            .clip(shape = RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                            .background(Color.White)
//                            .border(width = 1.dp, color = Color(0xFFff3779), shape = RoundedCornerShape(10.dp))
//                        .background(Color(0xFFff3779))
                            .padding(10.dp),  // Inner padding
//                            .height(columnHeight.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Apply Loan",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black, textAlign = TextAlign.Center
                        )
                    }
                }
//                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Card(
                    modifier = Modifier
                        .width(miniCardWidth.dp)
                        .height(columnHeight.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 10.dp
                    ),
                    onClick = { Log.i("HomeScreen", "Loan History is clicked")}
                ){
                    Column(
                        modifier = Modifier
                            .background(Color.White)
//                            .weight(0.25f)
                            .fillMaxHeight()
//                            .clip(shape = RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                            .background(Color.White)
//                            .border(width = 1.dp, color = Color(0xFFff3779), shape = RoundedCornerShape(10.dp))
//                        .background(Color(0xFFff3779))
                            .padding(10.dp),  // Inner padding
//                            .height(columnHeight.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Loan History",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black, textAlign = TextAlign.Center
                            )
                    }
                }
//                Spacer(modifier = Modifier.padding(horizontal = 22.dp))
                Card(
                    modifier = Modifier
                        .width(miniCardWidth.dp)
                        .height(columnHeight.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 10.dp
                    ),
                    onClick = { Log.i("HomeScreen", "My Account is clicked")}
                ){
                    Column(
                        modifier = Modifier
                            .background(Color.White)
//                            .weight(0.25f)
                            .fillMaxHeight()
//                            .clip(shape = RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                            .background(Color.White)
//                            .border(width = 1.dp, color = Color(0xFFff3779), shape = RoundedCornerShape(10.dp))
//                        .background(Color(0xFFff3779))
                            .padding(10.dp),  // Inner padding
//                            .height(columnHeight.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "My Account",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.Black, textAlign = TextAlign.Center
                            )
                    }
                }
        }
        //LAST CARD
//        Row(
//            modifier = Modifier
//                .align(Alignment.Start)
//                .padding(bottom = 10.dp)
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Text(
//                text = "Announcements",
//                style = TextStyle(
//                    fontFamily = customFontFamily(),
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 30.sp,
//                )
//            )
//        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height((columnHeight / 2).dp)
                .align(
                    alignment = Alignment.Start
                ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp,
                pressedElevation = 8.dp
            )
        ){
            //ANNOUNCEMENT CARD
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
//                    .background(Color(0xFFff3779)),
//                    .background(Color(0xFF0d0551)),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Wallet Balance",
                    fontFamily = customFontFamily(),
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                Text(
                    "GHs 5,000.00",
                    style = TextStyle(
                        fontFamily = customFontFamily(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.Black
                    )
                )
            }
        }
    }
}