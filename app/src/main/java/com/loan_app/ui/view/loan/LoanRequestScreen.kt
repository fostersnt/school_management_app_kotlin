package com.loan_app.ui.view.loan

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DropdownMenu
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.loan_app.ui.view.components.CustomButton
import com.loan_app.ui.viewmodel.LoanRequestViewModel
import com.loan_app.utilities.customFontFamily
import java.util.Objects


//@Preview(showBackground = true)
@OptIn(ExperimentalMaterialApi::class)
@Composable
//fun LoanRequestScreen(navController: NavController) {
////    viewModel.loanAmount.observeAsState("").value;
////    viewModel.selectedTerm.observeAsState("").value
////    viewModel.isConfirmed.observeAsState(false).value;
//
//    val viewModel: LoanRequestViewModel = viewModel();
//
//    var loanAmount = viewModel.loanAmount.observeAsState("").value;
//    var selectedTerm = viewModel.selectedTerm.observeAsState("").value;
//    var isConfirmed = viewModel.isConfirmed.observeAsState(false).value;
//    var isEnabled = viewModel.isEnabled.observeAsState(false).value;
//    var canShowModalNow = viewModel.canShowModal.observeAsState(false).value;
//
//    val availableAmount = 50000 // Example max available amount
//    val loanTerms = listOf("6 Months", "12 Months", "24 Months", "36 Months")
//
//    val configuration = LocalConfiguration.current;
//    val deviceHeight = configuration.screenHeightDp;
//    val customTopPadding = deviceHeight / 4;
//    val scrollState = rememberScrollState();
//
//    var expanded = false
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(top = customTopPadding.dp, start = 16.dp, bottom = 16.dp, end = 16.dp)
//            .verticalScroll(state = scrollState),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Available Max Amount
//        Text(
//            text = "Available Maximum Loan Amount:",
//            style = TextStyle(
//                textAlign = TextAlign.Center,
//                fontFamily = customFontFamily(),
//                fontSize = 20.sp
//            ),
//            color = Color.Black,
//            modifier = Modifier.padding(bottom = 5.dp)
//        )
//        Text(
//            text = buildAnnotatedString {
////                append("Available Maximum Loan Amount: ")
//                withStyle(style = SpanStyle(
//                    color = Color(0xFFff3779),
//                    fontSize = 30.sp,
//                    fontFamily = customFontFamily()
//                )){
//                    append("GHs ${availableAmount}")
//                }
//            },
//            style = TextStyle(textAlign = TextAlign.Center),
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        // Loan Amount Input Field
//        OutlinedTextField(
//            value = loanAmount,
//            onValueChange = { viewModel.setLoanAmount(it) },
//            textStyle = TextStyle(
//                fontWeight = FontWeight.Normal,
//                fontFamily = customFontFamily(),
//                color = Color.Black
//            ),
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = Color.White,
//                unfocusedContainerColor = Color.White,
//                focusedBorderColor = Color.Gray,
//            ),
//            label = { Text(
//                "Enter Expected Loan Amount",
//                style = MaterialTheme.typography.bodyLarge,
//                color = Color.Black,
//                fontWeight = FontWeight.Normal,
//                fontFamily = customFontFamily(),
//                fontSize = 20.sp
//            ) },
//            singleLine = true,
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Number,
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//                .height(60.dp)
////                .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
////                .padding(16.dp)
//        )
//
//        // Loan Term Dropdown
//        Box(modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 16.dp)
//            .background(Color.White, shape = MaterialTheme.shapes.small)
//            .border(1.dp, Color.Gray, shape = MaterialTheme.shapes.small)
//            .height(60.dp),
//            contentAlignment = Alignment.CenterStart
//        ) {
//            TextButton(onClick = { expanded = !expanded }) {
//                Text(
//                    text = "Loan Term: $selectedTerm",
//                    style = MaterialTheme.typography.bodyLarge,
//                    color = Color.Black,
//                    fontWeight = FontWeight.Normal,
//                    fontFamily = customFontFamily()
//                )
//            }
//
//            DropdownMenu(
//                border = BorderStroke(width = 1.dp, color = Color.Gray),
//                shape = RoundedCornerShape(10.dp),
//                expanded = expanded,
//                onDismissRequest = { expanded = false },
//            ) {
//                loanTerms.forEach { term ->
//                    DropdownMenuItem(
//                        modifier = Modifier.fillMaxWidth(),
//                        onClick = {
//                            viewModel.setLoanTerm(term)
//                        expanded = false
//                    }, text = {
//                        Text(
//                            text = term,
//                            style = TextStyle(fontWeight = FontWeight.Normal, fontFamily = customFontFamily())
//                        )
//                    }
//                    )
//                }
//            }
//        }
//
//        // Checkbox for confirming inputs
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.padding(bottom = 16.dp)
//        ) {
//            Checkbox(
//                checked = isConfirmed,
//                onCheckedChange = { viewModel.setConfirmation(it) },
//                modifier = Modifier.padding(end = 8.dp),
//                colors = CheckboxDefaults.colors(
//                    checkmarkColor = Color.White,
//                    checkedColor = Color(0xFFff3779),
//                )
//            )
//            Text(
//                "I confirm that the details entered are correct",
//                style = TextStyle(
//                    fontFamily = customFontFamily(),
//                ),
//            )
//        }
//        // Submit Button
//        isEnabled = isConfirmed && loanAmount.isNotEmpty();
//        Button(
//            onClick = { viewModel.setCanShowModal(true) },
//            enabled = isEnabled,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 16.dp)
//                .height(60.dp),
//            colors = ButtonDefaults.buttonColors(
//                    containerColor = Color(0xFFff3779)
//            ),
//            shape = RoundedCornerShape(10.dp)
//        ) {
//            Text(text = "Submit Loan Request")
//        }
//    }
//    if (canShowModalNow){
//        ShowModal({viewModel.setCanShowModal(!canShowModalNow)})
//    }
//}

fun LoanRequestScreen(navController: NavController) {
    fun onSubmit(loanAmount: String, term: String) = {}
    var loanAmount by remember { mutableStateOf("") }
    var selectedTerm by remember { mutableStateOf("Loan term") }
    var isExpanded by remember { mutableStateOf(false) }

    // List of payment terms
    val paymentTerms = listOf("12 months", "24 months", "36 months", "48 months", "60 months")

    // Function to calculate the max loan based on the selected term
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

    // Max loan amount based on selected payment term
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
            Text(text = "Preferred Loan Amount", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = loanAmount,
                onValueChange = { loanAmount = it },
                label = { Text("Enter Loan Amount") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFF00729C)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Payment Term Dropdown
            Text(text = "Select Payment Term", style = MaterialTheme.typography.bodyMedium)
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
                            text = { Text(term, style = TextStyle(fontFamily = customFontFamily(), color = Color.Black)) },
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
                onClick = { onSubmit(loanAmount, selectedTerm) },
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00729C)
                ),
                shape = RectangleShape
            ) {
                Text("Submit Application")
            }
        }
    }
}


@Composable
fun ShowModal(onDismiss: () -> Unit){
    AlertDialog(
        shape = RectangleShape,
        onDismissRequest = {}, // Dismiss dialog when user clicks outside
        title = { Text(
            "Modal Title",
            style = TextStyle(fontFamily = customFontFamily(), fontSize = 20.sp)
        ) },
        text = { Text(
            text = "Are you sure the above details are correct?",
            style = TextStyle(fontFamily = customFontFamily(), fontSize = 16.sp)
        ) },
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