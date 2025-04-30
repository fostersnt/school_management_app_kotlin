package com.loan_app.ui.view.loan

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.loan_app.ui.view.components.CustomButton
import com.loan_app.utilities.customFontFamily


@Preview(showBackground = true)
@Composable
fun LoanRequestScreen() {
    var loanAmount by remember { mutableStateOf(TextFieldValue("")) }
    var selectedTerm by remember { mutableStateOf("6 Months") }
    var isConfirmed by remember { mutableStateOf(false) }

    val availableAmount = 50000 // Example max available amount
    val loanTerms = listOf("6 Months", "12 Months", "24 Months", "36 Months")

    val configuration = LocalConfiguration.current;
    val deviceHeight = configuration.screenHeightDp;
    val customTopPadding = deviceHeight / 4;
    val scrollState = rememberScrollState();

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = customTopPadding.dp, start = 16.dp, bottom = 16.dp, end = 16.dp)
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Available Max Amount
        Text(
            text = "Available Maximum Loan Amount: \$${availableAmount}",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Loan Amount Input Field
        OutlinedTextField(
            value = loanAmount,
            onValueChange = { loanAmount = it },
            textStyle = TextStyle(
                fontWeight = FontWeight.Normal,
                fontFamily = customFontFamily(),
                color = Color.Black
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color.Gray
            ),
            label = { Text(
                "Enter Expected Loan Amount",
                style = TextStyle(fontFamily = customFontFamily())
            ) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .height(60.dp)
//                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
//                .padding(16.dp)
        )

        // Loan Term Dropdown
        var expanded by remember { mutableStateOf(false) }

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .background(Color.White, shape = MaterialTheme.shapes.small)
            .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
            .height(60.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            TextButton(onClick = { expanded = !expanded }) {
                Text(
                    text = "Loan Term: $selectedTerm",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                )
            }

            DropdownMenu(
                border = BorderStroke(width = 1.dp, color = Color.Black),
                shape = RoundedCornerShape(10.dp),
//                containerColor = Color.Red,
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                loanTerms.forEach { term ->
                    DropdownMenuItem(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                        selectedTerm = term
                        expanded = false
                    }, text = {
                        Text(
                            text = term,
                            style = TextStyle(fontWeight = FontWeight.Normal, fontFamily = customFontFamily())
                        )
                    }
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
                modifier = Modifier.padding(end = 8.dp),
                colors = CheckboxDefaults.colors(
                    checkmarkColor = Color.White,
                    checkedColor = Color(0xFFff3779),
                )
            )
            Text(
                "I confirm that the details entered are correct",
                style = TextStyle(
                    fontFamily = customFontFamily(),
                ),
            )
        }
    val enabled = isConfirmed && loanAmount.text.isNotEmpty()
        // Submit Button
        Button(
            onClick = { /* Handle submit action */ },
            enabled = isConfirmed && loanAmount.text.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFff3779)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Submit Loan Request")
        }
    }
}