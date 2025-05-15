package com.loan_app.ui.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.loan_app.R
import com.loan_app.data.model.AppColors
import com.loan_app.data.model.AppRoutes
import com.loan_app.ui.view.navigation.BottomNavigationBar
import com.loan_app.utilities.customFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//fun HomeScreen(navController: NavController) {
//    val menuItems = listOf(
//        MenuItem("Students", Icons.Default.Person, "25"),
//        MenuItem("Attendance", Icons.Default.Check),
//        MenuItem("Homework", Icons.Default.Edit),
//        MenuItem("Exams", Icons.Default.Warning)
//    )
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFF5F5F5)) // Light background
//            .padding(16.dp)
//    ) {
//        TopAppBarSection()
//        Spacer(modifier = Modifier.height(24.dp))
//
//        menuItems.forEach { item ->
//            MenuCard(item = item)
//            Spacer(modifier = Modifier.height(12.dp))
//        }
//    }
//}

fun HomeScreen(navController: NavController) {
    val menuItems = listOf(
        MenuItem("Students", Icons.Default.Person, "25"),
        MenuItem("Attendance", Icons.Default.Check),
        MenuItem("Homework", Icons.Default.Edit),
        MenuItem("Exams", Icons.Default.Warning)
    )

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(AppColors.BACKGROUND_COLOR),
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(20.dp).padding(paddingValue)
        ) {
            Column(
                modifier = Modifier
                    .heightIn(min = screenHeight * 2 / 3)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                menuItems.forEach { item ->
                    MenuCard(item = item, navController = navController)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}



@Composable
fun MenuCard(item: MenuItem, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(AppColors.BACKGROUND_COLOR))
            .padding(horizontal = 16.dp)
            .clickable(enabled = true, onClick = {navController.navigate(AppRoutes.TEST_SCREEN)}),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxSize(0.4f)
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = item.title,
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.weight(1f)
            )
        }
        item.count?.let {
            Text(
                text = it,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

data class MenuItem(
    val title: String,
    val icon: ImageVector,
    val count: String? = null
)

