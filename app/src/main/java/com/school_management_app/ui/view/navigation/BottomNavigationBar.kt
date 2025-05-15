package com.school_management_app.ui.view.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.school_management_app.data.model.AppColors
import com.school_management_app.utilities.customFontFamily

@Composable
fun BottomNavigationBar(navController: NavController, currentRoute: String?) {
    NavigationBar(
        containerColor = Color(AppColors.WHITE_COLOR),
//        contentColor = Color(AppColors.WHITE_COLOR)
    ) {
        BottomNavItems.list.forEachIndexed { currentIndex, item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(AppColors.BACKGROUND_COLOR),
                    selectedIconColor = Color(AppColors.WHITE_COLOR),
                    unselectedIconColor = Color(AppColors.BACKGROUND_COLOR),
                    selectedTextColor = Color(AppColors.TEXT_COLOR_TEA_BLUE),
                    unselectedTextColor = Color(AppColors.TEXT_COLOR_TEA_BLUE)
                ),
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 16.sp,
                        fontFamily = customFontFamily(),
//                        color = Color.Black,
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    val targetRoute = item.route

                    if (currentRoute != targetRoute) {
                        navController.navigate(targetRoute) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
            )
        }
    }
}


//fun BottomNavigationBar(navController: NavHostController) {
//    var selectedIndex = rememberSaveable { mutableIntStateOf(0) }
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
//                        selected = selectedIndex.intValue == currentIndex,
//                        onClick = {
//                            selectedIndex.intValue = currentIndex
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
