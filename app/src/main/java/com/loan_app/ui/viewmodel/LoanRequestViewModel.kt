//package com.loan_app.ui.viewmodel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//
//data class LoanUIState(
//    var loanAmount: String = "",
//    var selectedTerm: String = "",
//    var selectedMomoAccount: String = "",
//    var isExpanded: Boolean = false,
//    var isExpandedMomo: Boolean = false,
//    var canShowModal: Boolean = false
//)
//
//class LoanRequestViewModel(): ViewModel() {
//
//    private var _uiState = MutableLiveData(LoanUIState())
//    val uiState: LiveData<LoanUIState> = _uiState
//
//    private fun updateState(update: LoanUIState.() -> LoanUIState) {
//        _uiState.value = _uiState.value?.update()
//    }
//
//    fun setLoanAmount(amount: String) = updateState { copy(loanAmount = amount) }
//
//    fun setLoanTerm(term: String) = updateState { copy(selectedTerm = term) }
//
//    fun setSelectedMomoAccount(account: String) = updateState { copy(selectedMomoAccount = account) }
//
//    fun setIsExpanded(expanded: Boolean) = updateState { copy(isExpanded = expanded) }
//
//    fun setIsExpandedMomo(expanded: Boolean) = updateState { copy(isExpandedMomo = expanded) }
//
//    fun setCanShowModal(show: Boolean) = updateState { copy(canShowModal = show) }
//}

package com.loan_app.ui.viewmodel

import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class LoanUIState(
    var loanAmount: String = "",
    var selectedTerm: String = "",
    var selectedMomoAccount: String = "",
    var isExpanded: Boolean = false,
    var isExpandedMomo: Boolean = false,
    var canShowModal: Boolean = false,
    var loanTermList: List<String> = listOf<String>(),
    var loanInterest: String = "",
    var principalAmount: String = ""
)

class LoanRequestViewModel : ViewModel() {

    private val defaultInterestRate: Double = 0.15

    private val _uiState = MutableStateFlow(LoanUIState())
    val uiState: StateFlow<LoanUIState> = _uiState

    private fun updateState(update: LoanUIState.() -> LoanUIState) {
        _uiState.update { it.update() }
    }

    fun setPrincipalAmount(principal: String) = updateState { copy(principalAmount = ((principal.toDoubleOrNull() ?: 0.00) + (0.00)).toString()) }

    fun setLoanTerm(term: String) = updateState { copy(selectedTerm = term) }

    fun setSelectedMomoAccount(account: String) = updateState { copy(selectedMomoAccount = account) }

    fun setIsExpanded(expanded: Boolean) = updateState { copy(isExpanded = expanded) }

    fun setIsExpandedMomo(expanded: Boolean) = updateState { copy(isExpandedMomo = expanded) }

    fun setCanShowModal(show: Boolean) = updateState { copy(canShowModal = show) }

    fun setLoanAmount() = updateState { copy(loanAmount = ((principalAmount.toDoubleOrNull() ?: 0.0) + (loanInterest.toDoubleOrNull() ?: 0.0)).toString()) }

//    private val principalLoan = _uiState.value.loanAmount * defaultInterestRate * _uiState.value.selectedTerm

    fun setLoanTermList(principal: String, ) {
        val numericLoanAmount = principal.toDoubleOrNull() ?: 0.0
        when {
            numericLoanAmount <= 200 -> updateState { copy(loanTermList = listOf("15 days", "30 days")) }
            numericLoanAmount > 200 && numericLoanAmount <= 500 -> updateState { copy(loanTermList = listOf("15 days", "30 days", "45 days")) }
            else -> updateState { copy(loanTermList = listOf<String>()) }
        }
    }

    fun setInterestAmount(){
        val amount = _uiState.value.principalAmount.toDoubleOrNull() ?: 0.0;
        when(_uiState.value.selectedTerm.lowercase()){
            "15 days" -> updateState { copy(loanInterest = (defaultInterestRate * amount * 1).toString()) }
            "30 days" -> updateState { copy(loanInterest = (defaultInterestRate * amount * 2).toString()) }
            "45 days" -> updateState { copy(loanInterest = (defaultInterestRate * amount * 3).toString()) }
        }
    }
}
