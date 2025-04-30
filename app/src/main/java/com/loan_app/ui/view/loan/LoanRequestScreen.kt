package com.loan_app.ui.view.loan

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun LoanRequestScreen() {
    var loanAmount by remember { mutableStateOf(TextFieldValue("")) }
    var selectedTerm by remember { mutableStateOf("6 Months") }
    var isConfirmed by remember { mutableStateOf(false) }

    val availableAmount = 50000 // Example max available amount
    val loanTerms = listOf("6 Months", "12 Months", "24 Months", "36 Months")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Available Max Amount
        Text(
            text = "Available Maximum Loan Amount: \$${availableAmount}",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Loan Amount Input Field
        TextField(
            value = loanAmount,
            onValueChange = { loanAmount = it },
            label = { Text("Enter Expected Loan Amount") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
//            keyboardOptions = androidx.compose.ui.text.input.KeyboardOptions.Default.copy(
//                keyboardType = androidx.compose.ui.text.input.KeyboardType.Number
//            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
                .padding(16.dp)
        )

        // Loan Term Dropdown
        var expanded by remember { mutableStateOf(false) }

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .background(Color.White, shape = MaterialTheme.shapes.small)
            .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
        ) {
            TextButton(onClick = { expanded = !expanded }) {
                Text(
                    text = "Loan Term: $selectedTerm",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                loanTerms.forEach { term ->
                    DropdownMenuItem(onClick = {
                        selectedTerm = term
                        expanded = false
                    }, text = {Text(text = "Loan Term")}
                    )
                }
            }
        }

        // Checkbox for confirming inputs
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Checkbox(
                checked = isConfirmed,
                onCheckedChange = { isConfirmed = it },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("I confirm that the details entered are correct", style = MaterialTheme.typography.bodySmall)
        }

        // Submit Button
        Button(
            onClick = { /* Handle submit action */ },
            enabled = isConfirmed && loanAmount.text.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Submit Loan Request")
        }
    }
}