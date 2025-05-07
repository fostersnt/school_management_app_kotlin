package com.loan_app.ui.view.loan

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.loan_app.data.model.AppColors
import com.loan_app.ui.viewmodel.LoanHistoryItem
import com.loan_app.ui.viewmodel.LoanHistoryViewModel
import com.loan_app.ui.viewmodel.LoanStatus

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoanHistoryScreen(navController: NavController, viewModel: LoanHistoryViewModel = viewModel()) {
    val loans by viewModel.loanHistory.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Loan History") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(AppColors.BACKGROUND_COLOR),
                    titleContentColor = Color(AppColors.WHITE_COLOR)
                ),
                navigationIcon = {IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "",
                        tint = Color(
                            AppColors.WHITE_COLOR
                        )
                    )
                }}
            )
        }
    ) { innerPadding ->
        if(loans.isNotEmpty()){
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                items(loans) { loan ->
                    LoanHistoryCard(loan)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }else{
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "No history available", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

@Composable
fun LoanHistoryCard(loan: LoanHistoryItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Loan ID: ${loan.id}", fontWeight = FontWeight.Bold)
                StatusChip(loan.status)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text("Amount: ${loan.amount}")
            Text("Term: ${loan.term}")
            Text("Request Date: ${loan.requestDate}")
            Text("Completed Date: ${loan.completedDate}")
        }
    }
}

@Composable
fun StatusChip(status: LoanStatus) {
    val (label, bgColor, textColor) = when (status) {
        LoanStatus.APPROVED -> Triple("Approved", Color(0xFFD1FAE5), Color(0xFF065F46))
        LoanStatus.REJECTED -> Triple("Rejected", Color(0xFFFEE2E2), Color(0xFF991B1B))
        LoanStatus.PENDING -> Triple("Pending", Color(0xFFFFF7CD), Color(0xFF92400E))
    }

    Box(
        modifier = Modifier
            .background(bgColor, shape = RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(text = label, color = textColor, style = MaterialTheme.typography.labelSmall)
    }
}
