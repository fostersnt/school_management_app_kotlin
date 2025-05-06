package com.loan_app.ui.view.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.loan_app.data.model.AppRoutes
import com.loan_app.utilities.customFontFamily

@Composable
fun BottomNavigationBar(navController: NavHostController, currentRoute: String?) {
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
                selected = currentRoute == item.route,
                onClick = {
                    when(currentIndex){
                        0 -> navController.navigate(AppRoutes.HOME_SCREEN)
                        1 -> navController.navigate(AppRoutes.PROFILE_SCREEN)
                        2 -> navController.navigate(AppRoutes.SETTINGS_SCREEN)
                    }
                },
            )
        }
    }
}


//fun BottomNavigationBar(navController: NavHostController) {
//    var selectedIndex by remember { mutableIntStateOf(0) }
//
//    Scaffold(
////        topBar = {
////            TopAppBar(title = {Text("Loan App")}, modifier = Modifier.statusBarsPadding())
////        },
//        bottomBar = {
//            NavigationBar {
//                BottomNavItems.list.forEachIndexed { currentIndex, item ->
//                    NavigationBarItem(
//                        icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
//                        label = {
//                            Text(
//                                text = item.title,
//                                fontSize = 16.sp,
//                                fontFamily = customFontFamily(),
//                                color = Color.Black,
//                            )
//                        },
//                        selected = selectedIndex == currentIndex,
//                        onClick = {
//                            selectedIndex = currentIndex
////                            if (selectedIndex == 0){
////                                navController.navigate(AppRoutes.HOME_SCREEN)
////                            }else if (selectedIndex == 1){
////                                navController.navigate(AppRoutes.PROFILE_SCREEN)
////                            }else if (selectedIndex == 2){
////                                navController.navigate(AppRoutes.SETTINGS_SCREEN)
////                            }
//                            if (navController.currentDestination?.route != item.route) {
//                                navController.navigate(item.route) {
//                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
//                                    launchSingleTop = true
//                                    restoreState = true
//                                }
//                            }
//                        },
//                    )
//                }
//            }
//        },
//        content = {myPadding -> NavigationGraph(navController, paddingValues = myPadding)}
//    )
//
//}