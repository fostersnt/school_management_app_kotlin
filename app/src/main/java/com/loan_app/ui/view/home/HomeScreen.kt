package com.loan_app.ui.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavHostController
import com.loan_app.R
import com.loan_app.data.model.AppColors
import com.loan_app.data.model.AppRoutes
import com.loan_app.ui.view.navigation.BottomNavigationBar
import com.loan_app.utilities.customFontFamily

private val cardImages = listOf(
    R.drawable.card_1_image,
    R.drawable.card_2_image,
    R.drawable.card_3_image
)

@Composable
//fun HomeScreen(navController: NavHostController){
//    Button(
//        onClick = {navController.navigate(AppRoutes.LOAN_REQUEST_SCREEN)}
//    ) {
//        Text(text = "NEXT")
//    }
//}

fun HomeScreen(navController: NavController){

    val scrollState = rememberScrollState();
    val myCustomFontFamily = customFontFamily()

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
                CustomCard(navController, "Apply Loan", AppRoutes.LOAN_REQUEST_SCREEN, cardImages[0])
                CustomCard(navController, "Loan History", AppRoutes.LOAN_HISTORY_SCREEN, cardImages[1])
                CustomCard(navController, "My Account", AppRoutes.TEST_SCREEN, cardImages[2])
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
    val screenWidth = configuration.screenWidthDp;
    val miniCardWidth = ((screenWidth - (0.1 * screenWidth)) / 3) - 10;

    Card(
        modifier = Modifier
            .width(miniCardWidth.dp)
            .fillMaxHeight(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
            pressedElevation = 10.dp
        ),
        onClick = {
            navController.navigate(route = myRoute)
        }
    ){
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageIcon),
                contentDescription = "",
                Modifier.aspectRatio(1f)
            )
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black, textAlign = TextAlign.Center
            )
        }
    }
}