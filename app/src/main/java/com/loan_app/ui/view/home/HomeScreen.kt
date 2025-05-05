package com.loan_app.ui.view.home

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.loan_app.utilities.customFontFamily
import com.loan_app.R
import com.loan_app.ui.view.navigation.AppRoutes

//@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavController){

    val configuration = LocalConfiguration.current
    val screenWidth = remember { configuration.screenWidthDp }
    val screenHeight = remember { configuration.screenHeightDp }

    val myCustomFontFamily = remember { customFontFamily() }

    val columnHeight = remember { (screenHeight - (0.1 * screenHeight)) / 3 };
    val miniCardWidth = remember { ((screenWidth - (0.1 * screenWidth)) / 3) - 10 }; //20 represent the padding that has been applied to the main Column Container
    val scrollState = rememberScrollState();

    Column(
        modifier = Modifier
            .fillMaxSize()
        .padding(20.dp)
            .statusBarsPadding()
            .verticalScroll(state = scrollState)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 10.dp),
        ) {
            Text(
                text = "Hi Foster",
                style = TextStyle(
                    fontFamily = myCustomFontFamily,
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
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Loan Balance",
                    fontFamily = myCustomFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "GHs 5,000.00",
                    style = TextStyle(
                        fontFamily = myCustomFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color(0xFFff3779)
                    )
                )
            }
        }
        //SECOND GROUP OF CARDS
        Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height((columnHeight - (0.1 * columnHeight)).dp)
                    .fillMaxWidth(1f)
            ) {
                val img1 = R.drawable.card_1_image;
                val img2 = R.drawable.card_2_image;
                val img3 = R.drawable.card_3_image;

                CustomCard(navController, "Apply Loan", AppRoutes.loan_request_screen, miniCardWidth, columnHeight, img1)
                CustomCard(navController, "Loan History", AppRoutes.settings_screen, miniCardWidth, columnHeight, img2)
                CustomCard(navController, "My Account", AppRoutes.loan_history_screen, miniCardWidth, columnHeight, img3)
        }

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
                    fontFamily = myCustomFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "GHs 5,000.00",
                    style = TextStyle(
                        fontFamily = myCustomFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = Color.Black
                    )
                )
            }
        }
    }
}

@Composable
fun CustomCard(
    navController: NavController,
    label: String,
    myRoute: String,
    miniCardWidth: Double,
    columnHeight: Double,
    imageIcon: Int
){
    Card(
        modifier = Modifier
            .width(miniCardWidth.dp),
//            .height(columnHeight.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
            pressedElevation = 10.dp
        ),
        onClick = {
            Log.i("HomeScreen", label)
            navController.navigate(route = myRoute)
        }
    ){
        Column(
            modifier = Modifier
                .background(Color.White)
//                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageIcon),
                contentDescription = "",
                Modifier.width((miniCardWidth).dp).height((columnHeight / 2).dp)
            )
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black, textAlign = TextAlign.Center
            )
        }
    }
}