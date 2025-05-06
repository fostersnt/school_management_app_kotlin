package com.loan_app.ui.view.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
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
import com.loan_app.R
import com.loan_app.data.model.AppColors
import com.loan_app.data.model.AppRoutes
import com.loan_app.utilities.customFontFamily

//@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavController){

//    val configuration = LocalConfiguration.current;
////    val configuration = config.value.current;
//    val screenWidth = remember { configuration.screenWidthDp }
//    val screenHeight = remember { configuration.screenHeightDp }
////
//    val columnHeight = remember { (screenHeight - (0.1 * screenHeight)) / 3 } ;
//    val miniCardWidth = remember { mutableDoubleStateOf(((screenWidth - (0.1 * screenWidth)) / 3) - 10) };

    val scrollState = rememberScrollState();
//    val miniCardWidth = 200.0
//    val columnHeight = 200.0
    val myCustomFontFamily = remember { customFontFamily() }

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
                .height(200.dp)
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
                        color = Color(AppColors.BACKGROUND_COLOR)
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
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                val img1 = R.drawable.card_1_image;
                val img2 = R.drawable.card_2_image;
                val img3 = R.drawable.card_3_image;

                CustomCard(navController, "Apply Loan", AppRoutes.LOAN_REQUEST_SCREEN, img1)
                CustomCard(navController, "Loan History", AppRoutes.SETTINGS_SCREEN, img2)
                CustomCard(navController, "My Account", AppRoutes.LOAN_HISTORY_SCREEN, img3)
            }

        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
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
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.White),
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
    imageIcon: Int
){
    val configuration = LocalConfiguration.current;
//    val configuration = config.value.current;
    val screenWidth = remember { configuration.screenWidthDp }
//    val screenHeight = remember { configuration.screenHeightDp }
//
//    val columnHeight = remember { (screenHeight - (0.1 * screenHeight)) / 3 } ;
    val miniCardWidth = remember { ((screenWidth - (0.1 * screenWidth)) / 3) - 10 };

    Card(
        modifier = Modifier
            .width(miniCardWidth.dp)
            .fillMaxHeight(),
//        shape = RoundedCornerShape(20.dp),
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
                .fillMaxHeight()
                .fillMaxWidth(),
//                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageIcon),
                contentDescription = "",
                Modifier.width(100.dp).height((100).dp)
            )
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black, textAlign = TextAlign.Center
            )
        }
    }
}