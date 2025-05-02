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
    private var _loanAmount =  MutableLiveData("");
    private var _selectedTerm =  MutableLiveData("6 Months");
    private var _isConfirmed = MutableLiveData(false);
    private var _canShowModal = MutableLiveData(false);
    private var _isEnabled = MutableLiveData(false);

    val loanAmount: LiveData<String> =  _loanAmount;
    val selectedTerm: LiveData<String> =  _selectedTerm;
    var isConfirmed: LiveData<Boolean> = _isConfirmed;
    var canShowModal: LiveData<Boolean> = _canShowModal;
    var isEnabled: LiveData<Boolean> = _isEnabled;

    fun setLoanAmount(amount: String): Unit{
        _loanAmount.value = amount
        Log.i("setLoanAmount", "VALUE === $amount")
    }

    fun setLoanTerm(loanTerm: String): Unit{
        _selectedTerm.value = loanTerm
        Log.i("setLoanAmount", "VALUE === $loanTerm")
    }

    fun setConfirmation(confirmation: Boolean): Unit{
        _isConfirmed.value = confirmation
        Log.i("setLoanAmount", "VALUE === $confirmation")
    }

    fun setIsEnabled(enabled: Boolean): Unit{
        _isEnabled.value = enabled
        Log.i("setLoanAmount", "VALUE === $enabled")
    }

    fun setCanShowModal(showModal: Boolean): Unit{
        _canShowModal.value = showModal
        Log.i("setLoanAmount", "VALUE === $showModal")
    }

//    fun getLoanAmount(): LiveData<String>{
//        return loanAmount;
//    }
//
//    fun getSelectedTerm(): LiveData<String>{
//        return selectedTerm;
//    }
//
//    fun getConfirmation(): LiveData<Boolean>{
//        return isConfirmed;
//    }
}