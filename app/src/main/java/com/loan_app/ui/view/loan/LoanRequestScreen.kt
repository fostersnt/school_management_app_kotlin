package com.loan_app.ui.view.loan


import androidx.compose.foundation.BorderStroke
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
    fun onSubmit(loanAmount: String, term: String) = {}
    var loanAmount by remember { mutableStateOf("") }
    var selectedTerm by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }
    var canShowModal by remember { mutableStateOf(false) }

    if (canShowModal == true){
        ShowModal({canShowModal = !canShowModal}, loanAmount);
    }

    val paymentTerms = listOf("1 months", "2 months", "3 months", "4 months", "5 months")

    fun getMaxLoanAmount(term: String): Int {
        return when (term) {
            "12 months" -> 10000
            "24 months" -> 20000
            "36 months" -> 30000
            "48 months" -> 40000
            "60 months" -> 50000
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

            Spacer(modifier = Modifier.height(16.dp))

            // Max Loan Amount Display
            Text(
                text = "Maximum Available Loan: $${maxLoanAmount}",
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
fun ShowModal(onDismiss: () -> Unit, amount: String){
    AlertDialog(
        shape = RectangleShape,
        onDismissRequest = {}, // Dismiss dialog when user clicks outside
        title = { Text(
            "Modal Title",
            style = TextStyle(fontFamily = customFontFamily(), fontSize = 20.sp)
        ) },
        text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Are you sure the above details are correct?",
                    style = TextStyle(fontFamily = customFontFamily(), fontSize = 16.sp)
                )
                Text(
                    text = "Loan Amount: $amount",
                    style = TextStyle(fontFamily = customFontFamily(), fontSize = 16.sp)
                )
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


@Preview(showBackground = true)
@Composable
fun MyModalDisplay(){
    fun sampleFun(){
//        return;
    }
//    ShowModal({sampleFun()})
    LoanRequestScreen(navController = rememberNavController())
}