package com.loan_app.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoanRequestViewModel(): ViewModel() {

    private var _loanAmount = MutableLiveData("")
    private var _selectedTerm = MutableLiveData("")
    private var _selectedMomoAccount = MutableLiveData("")
    private var _isExpanded = MutableLiveData(false)
    private var _isExpandedMomo = MutableLiveData(false)
    private var _canShowModal = MutableLiveData(false)

    val loanAmount: LiveData<String> =  _loanAmount;
    val selectedMomoAccount: LiveData<String> = _selectedMomoAccount;
    val selectedTerm: LiveData<String> =  _selectedTerm;
    val canShowModal: LiveData<Boolean> = _canShowModal;
    val isExpandedMomo: LiveData<Boolean> = _isExpandedMomo;
    val isExpanded: LiveData<Boolean> = _isExpanded;

    fun setLoanAmount(incoming: String): Unit{
        _loanAmount.value = incoming
        Log.i("setLoanAmount", "VALUE === $incoming")
    }

    fun setLoanTerm(incoming: String): Unit{
        _selectedTerm.value = incoming
        Log.i("setLoanAmount", "VALUE === $incoming")
    }

    fun setSelectedMomoAccount(incoming: String): Unit{
        _selectedMomoAccount.value = incoming
        Log.i("setLoanAmount", "VALUE === $incoming")
    }

    fun setIsExpanded(incoming: Boolean): Unit{
        _isExpanded.value = incoming
        Log.i("setLoanAmount", "VALUE === $incoming")
    }
    fun setIsExpandedMomo(incoming: Boolean): Unit{
        _isExpandedMomo.value = incoming
        Log.i("setLoanAmount", "VALUE === $incoming")
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