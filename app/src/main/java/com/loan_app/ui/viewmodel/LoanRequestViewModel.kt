package com.loan_app.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoanRequestViewModel(): ViewModel() {
    var loanAmount =  MutableLiveData("")
    var selectedTerm =  MutableLiveData("6 Months")
    var isConfirmed = MutableLiveData(false)

    fun setLoanAmount(amount: String): Unit{
        loanAmount.value = amount
        Log.i("setLoanAmount", "VALUE === $amount")
    }

    fun setLoanTerm(loanTerm: String): Unit{
        selectedTerm.value = loanTerm
        Log.i("setLoanAmount", "VALUE === $loanTerm")
    }

    fun setConfirmation(confirmation: Boolean): Unit{
        isConfirmed.value = confirmation
        Log.i("setLoanAmount", "VALUE === $confirmation")
    }

    fun getLoanAmount(): LiveData<String>{
        return loanAmount;
    }

    fun getSelectedTerm(): LiveData<String>{
        return selectedTerm;
    }

    fun getConfirmation(): LiveData<Boolean>{
        return isConfirmed;
    }
}