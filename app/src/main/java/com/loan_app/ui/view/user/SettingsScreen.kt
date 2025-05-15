package com.loan_app.ui.view.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.loan_app.data.model.AppColors
import com.loan_app.ui.viewmodel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController, viewModel: SettingsViewModel = viewModel()) {
    var showDialog by remember { mutableStateOf(false) }
    var newMsisdn by remember { mutableStateOf(TextFieldValue("")) }

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(AppColors.BACKGROUND_COLOR),
            darkIcons = false // Set to true if background is light
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings", style = MaterialTheme.typography.titleLarge) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(
                                AppColors.WHITE_COLOR
                            )
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                shape = RoundedCornerShape(30.dp),
                containerColor = Color(
                    AppColors.BACKGROUND_COLOR
                ),
                contentColor = Color(AppColors.WHITE_COLOR),
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 10.dp
                )
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { padding ->
        if(viewModel.msisdns.isEmpty()){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp)
            ) {
                Text("No MoMo Account yet. Click the + button to add.", color = Color.Gray, textAlign = TextAlign.Center)
            }
        }else{
            Column(modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
            ) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(viewModel.msisdns.size) { index ->
                        val msisdn = viewModel.msisdns[index]
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(msisdn, style = MaterialTheme.typography.bodyLarge)
                                IconButton(onClick = { viewModel.removeMsisdn(msisdn) }) {
                                    Icon(Icons.Default.Delete, contentDescription = "Remove", tint = Color(
                                        AppColors.BACKGROUND_COLOR))
                                }
                            }
                        }
                    }
                }
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.addMsisdn(newMsisdn.text)
                            newMsisdn = TextFieldValue("")
                            showDialog = false
                        }
                    ) {
                        Text("Add")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                },
                title = { Text("Add MSISDN") },
                text = {
                    OutlinedTextField(
                        value = newMsisdn,
                        onValueChange = { newMsisdn = it },
                        label = { Text("Enter MSISDN") },
                        singleLine = true
                    )
                }
            )
        }
    }
}
