package com.loan_app.ui.view.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.loan_app.data.model.AppColors

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Student Profile", style = MaterialTheme.typography.titleLarge) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        androidx.compose.material3.Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(
                                AppColors.WHITE_COLOR
                            )
                        )
                    }
                }
            )
        }
    ) {paddingValue ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(horizontal = 16.dp)
                .padding(paddingValue)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
//                    .heightIn(min = screenHeight * 2 / 3)
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
//                        .background(Color(0xFF388E3C))
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
//                            tint = Color.White,
                            modifier = Modifier.size(64.dp)
                        )
                        Text(
                            text = "Ama Mensah",
//                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Student ID: JHS1-2025-0013",
//                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 14.sp
                        )
                        Text(
                            text = "Class: JHS 1 - Green",
//                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Info Cards
                InfoCard("Phone Number", "+233 54 123 4567")
                InfoCard("Date of Birth", "12th March 2012")
                InfoCard("Guardian", "Mary Mensah")
                InfoCard("Guardian Contact", "+233 24 987 6543")
                InfoCard("Address", "Kwashieman, Accra")

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {  },
                    modifier = Modifier.fillMaxWidth()
                        .height(80.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(AppColors.BACKGROUND_COLOR)
                    )
                ) {
                    Text("Edit Profile", color = Color(AppColors.WHITE_COLOR))
                }
            }
        }
    }
}


@Composable
fun InfoCard(label: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = label, fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = value, fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
    }
}