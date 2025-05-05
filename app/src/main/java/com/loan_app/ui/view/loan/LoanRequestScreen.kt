package com.loan_app.ui.view.loan


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.DropdownMenu
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.loan_app.utilities.customFontFamily


//@Preview(showBackground = true)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoanRequestScreen(navController: NavController) {
    var loanAmount by remember { mutableStateOf("") }
    var selectedTerm by remember { mutableStateOf("") }
    var selectedMomoAccount by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }
    var isExpandedMomo by remember { mutableStateOf(false) }
    var canShowModal by remember { mutableStateOf(false) }

    if (canShowModal == true){
        ShowModal(
            { canShowModal = !canShowModal },
            loanAmount,
            "100",
            "400",
            selectedTerm,
            "12-05-2025"
        );
    }

    val paymentTerms = listOf("1 months", "2 months", "3 months", "4 months", "5 months")
    val momoAccounts = listOf("0553255225", "0242677689")

    fun getMaxLoanAmount(term: String): Int {
        return when (term) {
            "1 months" -> 10000
            "2 months" -> 20000
            "3 months" -> 30000
            "4 months" -> 40000
            "5 months" -> 50000
            else -> 0
        }
    }

    val maxLoanAmount = getMaxLoanAmount(selectedTerm)

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                title = { Text("Loan Application") },
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
                onValueChange = { loanAmount = it },
                label = { Text("Enter Loan Amount", style = MaterialTheme.typography.bodyMedium, color = Color.Black) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFF00729C),
                ),
                textStyle = TextStyle(textAlign = TextAlign.Start)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Payment Term Dropdown
            Text(text = "Select Payment Term", style = MaterialTheme.typography.bodyMedium, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))

            //LOAN TERM SELECTION
            Column {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(width = 1.dp, color = Color(0xFF00729C)),
                    onClick = {isExpanded = !isExpanded},
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = selectedTerm, style = TextStyle(fontFamily = customFontFamily(), color = Color.Black))
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "", tint = Color.Black)
                    }
                    Spacer(Modifier.padding(vertical = 20.dp))
                }
                DropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = {isExpanded = false}
                ) {
                    paymentTerms.forEach { term ->
                        DropdownMenuItem(
                            text = { Text(term, style = MaterialTheme.typography.bodyMedium, color = Color.Black) },
                            onClick = { isExpanded = false; selectedTerm = term }
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
                    onClick = {isExpandedMomo = !isExpandedMomo},
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = selectedMomoAccount, style = TextStyle(fontFamily = customFontFamily(), color = Color.Black))
                        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "", tint = Color.Black)
                    }
                    Spacer(Modifier.padding(vertical = 20.dp))
                }
                DropdownMenu(
                    expanded = isExpandedMomo,
                    onDismissRequest = {isExpandedMomo = false}
                ) {
                    momoAccounts.forEach { momo ->
                        DropdownMenuItem(
                            text = { Text(momo, style = MaterialTheme.typography.bodyMedium, color = Color.Black) },
                            onClick = { isExpandedMomo = false; selectedMomoAccount = momo }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Max Loan Amount Display
            Text(
                text = "Maximum Available Loan: Ghs $maxLoanAmount",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Submit Button
            Button(
                onClick = { canShowModal = true },
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00729C)
                ),
                shape = RectangleShape,
                enabled = loanAmount.isNotEmpty() && selectedTerm.isNotEmpty()
            ) {
                Text("Submit Application")
            }
        }
    }
}


@Composable
fun ShowModal(
    onDismiss: () -> Unit,
    principal: String,
    interest: String,
    loanAmount: String,
    loanTerm: String,
    firstRepaymentDate: String
){
    AlertDialog(
        containerColor = Color.White,
        shape = RectangleShape,
        onDismissRequest = {}, // Dismiss dialog when user clicks outside
        title = { Text(
            "Loan Details",
            style = TextStyle(fontFamily = customFontFamily(), fontSize = 20.sp)
        ) },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Please review the loan details below:",
                    style = TextStyle(fontFamily = customFontFamily(), fontSize = 16.sp)
                )
                Spacer(Modifier.height(20.dp))
                InfoRow("Principal:", principal)
                InfoRow("Interest:", interest)
                InfoRow("Loan Amount:", loanAmount)
                InfoRow("Loan Term:", loanTerm)
                InfoRow("1st Repayment Date:", firstRepaymentDate)
            }
        },
        confirmButton = {
            Button(onClick = {
                onDismiss() // Close the modal
            }) {
                Text("Proceed")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                onDismiss() // Close the modal
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFff3779))
            ) {
                Text("Go Back")
            }
        }
    )
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            label,
            style = TextStyle(fontFamily = customFontFamily(), fontSize = 16.sp),
            modifier = Modifier.weight(1f)
        )
        Text(
            value,
            style = TextStyle(fontFamily = customFontFamily(), fontSize = 16.sp, fontWeight = FontWeight.SemiBold),
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MyModalDisplay(){
    fun sampleFun(){
//        return;
    }
//    ShowModal({sampleFun()})
    LoanRequestScreen(navController = rememberNavController())
}