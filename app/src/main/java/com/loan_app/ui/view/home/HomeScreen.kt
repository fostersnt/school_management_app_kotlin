package com.loan_app.ui.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.font.FontFamily
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
fun HomeScreen(navController: NavController) {
    val myCustomFontFamily = customFontFamily()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
//        bottomBar = { BottomNavigationBar(navController, "") }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = "Hi Foster 👋",
                    style = TextStyle(
                        fontFamily = myCustomFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 26.sp
                    ),
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

            item {
                InfoCard(
                    title = "Loan Balance",
                    value = "GHs 5,000.00",
                    valueColor = Color(AppColors.BACKGROUND_COLOR),
                    myCustomFontFamily
                )
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Quick Actions",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    QuickActionCard(navController, "Apply", AppRoutes.LOAN_REQUEST_SCREEN, cardImages[0])
                    QuickActionCard(navController, "History", AppRoutes.LOAN_HISTORY_SCREEN, cardImages[1])
                    QuickActionCard(navController, "Account", AppRoutes.TEST_SCREEN, cardImages[2])
                }
            }

//            item {
//                Spacer(modifier = Modifier.height(20.dp))
//                InfoCard(
//                    title = "Wallet Balance",
//                    value = "GHs 5,000.00",
//                    valueColor = Color.Black,
//                    myCustomFontFamily
//                )
//            }
        }
    }
}

@Composable
fun InfoCard(
    title: String,
    value: String,
    valueColor: Color,
    fontFamily: FontFamily
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(AppColors.WHITE_COLOR)) // light gray background
//        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)) // light gray background
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Decorative Icon or Badge
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(
                        color = Color(0xFFE0F7FA),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splash_icon), // Replace with your icon
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontFamily = fontFamily,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = value,
                    style = TextStyle(
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = valueColor
                    )
                )
            }
        }
    }
}


//@Composable
//fun InfoCard(title: String, value: String, valueColor: Color, fontFamily: FontFamily) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(180.dp),
//        shape = RoundedCornerShape(20.dp),
//        elevation = CardDefaults.cardElevation(8.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White)
//                .padding(16.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(title, fontFamily = fontFamily, fontSize = 18.sp)
//            Spacer(modifier = Modifier.height(10.dp))
//            Text(
//                value,
//                style = TextStyle(
//                    fontFamily = fontFamily,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 28.sp,
//                    color = valueColor
//                )
//            )
//        }
//    }
//}

@Composable
fun QuickActionCard(
    navController: NavController,
    label: String,
    route: String,
    iconRes: Int
) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(130.dp)
            .background(Color(AppColors.WHITE_COLOR)),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        onClick = { navController.navigate(route) }
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .aspectRatio(1f)
            )
            Text(
                text = label,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )
        }
    }
}
