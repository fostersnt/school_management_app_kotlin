package com.loan_app.ui.view.loan


import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenu
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
//import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.loan_app.data.model.AppColors
import com.loan_app.ui.viewmodel.LoanRequestViewModel
import com.loan_app.ui.viewmodel.LoanUIState
import com.loan_app.utilities.customFontFamily
//import androidx.compose.runtime.getValue

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LoanRequestScreen(navController: NavController, viewModel: LoanRequestViewModel = viewModel()) {

    val uiState by viewModel.uiState.observeAsState(LoanUIState())

    val loanAmount = uiState.loanAmount
    val selectedTerm = uiState.selectedTerm
    val selectedMomoAccount = uiState.selectedMomoAccount
    val isExpanded = uiState.isExpanded
    val isExpandedMomo = uiState.isExpandedMomo
    val canShowModal = uiState.canShowModal


//    if (canShowModal == true){
//        ShowModal(
//          onDismiss =   { viewModel.setCanShowModal(false) },
//            loanAmount,
//            "100",
//            "400",
//            selectedTerm,
//            selectedMomoAccount,
//            "12-05-2025"
//        );
//    }

    val paymentTerms = listOf("1 months", "2 months", "3 months", "4 months", "5 months")
    val momoAccounts = listOf("0553255225", "0242677689")

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                title = { "" },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Loan Amount Input Field
            Text(text = "Preferred Loan Amount", style = MaterialTheme.typography.bodyMedium, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = loanAmount,
                onValueChange = { viewModel.setLoanAmount(it) },
                label = { Text("Enter Loan Amount", style = MaterialTheme.typography.bodyMedium, color = Color.Black) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(AppColors.WHITE_COLOR)),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(AppColors.BACKGROUND_COLOR),
                ),
                textStyle = TextStyle(textAlign = TextAlign.Start)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Payment Term Dropdown
            Text(
                text = "Select Payment Term",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))

            //LOAN TERM SELECTION
            Column {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(width = 1.dp, color = Color(0xFF00729C)),
                    onClick = {viewModel.setIsExpanded(!isExpanded)},
                    shape = RectangleShape,
                    contentPadding = PaddingValues(vertical = 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = selectedTerm, style = TextStyle(fontFamily = customFontFamily(), color = Color.Black))
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "", tint = Color.Black)
                    }
                }
                DropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = {viewModel.setIsExpanded(false)}
                ) {
                    paymentTerms.forEach { term ->
                        DropdownMenuItem(
                            text = { Text(term, style = MaterialTheme.typography.bodyMedium, color = Color.Black) },
                            onClick = { viewModel.setIsExpanded(false); viewModel.setLoanTerm(term) }
                        )
                    }
                }
            }

            //MOMO ACCOUNT SELECTION
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Select Momo Account", style = MaterialTheme.typography.bodyMedium, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(width = 1.dp, color = Color(0xFF00729C)),
                    onClick = {viewModel.setIsExpandedMomo(!isExpandedMomo)},
                    shape = RectangleShape,
                    contentPadding = PaddingValues(vertical = 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = selectedMomoAccount, style = TextStyle(fontFamily = customFontFamily(), color = Color.Black))
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "", tint = Color.Black)
                    }
                }
                DropdownMenu(
                    expanded = isExpandedMomo,
                    onDismissRequest = {viewModel.setIsExpandedMomo(false)}
                ) {
                    momoAccounts.forEach { momo ->
                        DropdownMenuItem(
                            text = { Text(momo, style = MaterialTheme.typography.bodyMedium, color = Color.Black) },
                            onClick = { viewModel.setIsExpandedMomo(false); viewModel.setSelectedMomoAccount(momo) }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(32.dp))

            // Submit Button
            Button(
                onClick = {
                    viewModel.setCanShowModal(true)
                    Log.i("LoanRequestScreen", "CURRENT VALUES === $uiState")
                          },
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00729C)
                ),
                shape = RectangleShape,
                enabled = loanAmount.isNotEmpty() && selectedTerm.isNotEmpty()
            ) {
                Text("Next")
            }
        }
    }
}


//@Composable
//fun ShowModal(
//    onDismiss: () -> Unit,
//    principal: String,
//    interest: String,
//    loanAmount: String,
//    loanTerm: String,
//    momoAccount: String,
//    firstRepaymentDate: String
//){
//    AlertDialog(
//        containerColor = Color.White,
//        shape = RectangleShape,
//        onDismissRequest = {}, // Dismiss dialog when user clicks outside
//        title = { Text(
//            "Loan Details",
//            style = TextStyle(fontFamily = customFontFamily(), fontSize = 20.sp)
//        ) },
//        text = {
//            Column(modifier = Modifier.fillMaxWidth()) {
//                Text(
//                    text = "Please review the loan details below:",
//                    style = TextStyle(fontFamily = customFontFamily(), fontSize = 16.sp)
//                )
//                Spacer(Modifier.height(20.dp))
//                InfoRow("Principal:", principal)
//                InfoRow("Interest:", interest)
//                InfoRow("Loan Amount:", loanAmount)
//                InfoRow("Loan Term:", loanTerm)
//                InfoRow("Momo Account:", momoAccount)
//                InfoRow("1st Repayment Date:", firstRepaymentDate)
//            }
//        },
//        confirmButton = {
//            Button(
//                shape = RectangleShape,
//                onClick = {
//                    onDismiss() // Close the modal
//                },
//            ) {
//                Text("Submit")
//            }
//        },
//        dismissButton = {
//            Button(
//                shape = RectangleShape,
//                onClick = {
//                onDismiss() // Close the modal
//            },
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFff3779))
//            ) {
//                Text("Go Back")
//            }
//        }
//    )
//}
//
//@Composable
//fun InfoRow(label: String, value: String) {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Text(
//            label,
//            style = TextStyle(fontFamily = customFontFamily(), fontSize = 16.sp),
//            modifier = Modifier.weight(1f)
//        )
//        Text(
//            value,
//            style = TextStyle(fontFamily = customFontFamily(), fontSize = 16.sp, fontWeight = FontWeight.SemiBold),
//            modifier = Modifier.weight(1f),
//            textAlign = TextAlign.End
//        )
//    }
//}