package com.loan_app.ui.view.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.loan_app.ui.view.home.HomeScreen
import com.loan_app.ui.view.user.ProfileScreen
import com.loan_app.ui.view.user.SettingsScreen
import com.loan_app.utilities.customFontFamily

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
//        topBar = {
//            TopAppBar(title = {Text("Loan App")}, modifier = Modifier.statusBarsPadding())
//        },
        bottomBar = {
            NavigationBar {
                BottomNavItems.list.forEachIndexed { currentIndex, item ->
                    NavigationBarItem(
                        icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                        label = {
                            Text(
                                text = item.title,
                                fontSize = 16.sp,
                                fontFamily = customFontFamily(),
                                color = Color.Black,
                            )
                        },
                        selected = selectedIndex == currentIndex,
                        onClick = {
                            selectedIndex = currentIndex
                        },
                    )
                }
            }
        },
    )
    {
        BottomTabScreenContent(Modifier.padding(it), selectedIndex, navController)
    }

}

@Composable
fun BottomTabScreenContent(modifier: Modifier, index: Int, navController: NavHostController){
    when(index){
        0 -> HomeScreen(navController)
        1 -> ProfileScreen(navController)
        2 -> SettingsScreen(navController)
    }
}