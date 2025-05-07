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
    var canShowModal: Boolean = false
)

class LoanRequestViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoanUIState())
    val uiState: StateFlow<LoanUIState> = _uiState

    private fun updateState(update: LoanUIState.() -> LoanUIState) {
        _uiState.update { it.update() }
    }

    fun setLoanAmount(amount: String) = updateState { copy(loanAmount = amount) }

    fun setLoanTerm(term: String) = updateState { copy(selectedTerm = term) }

    fun setSelectedMomoAccount(account: String) = updateState { copy(selectedMomoAccount = account) }

    fun setIsExpanded(expanded: Boolean) = updateState { copy(isExpanded = expanded) }

    fun setIsExpandedMomo(expanded: Boolean) = updateState { copy(isExpandedMomo = expanded) }

    fun setCanShowModal(show: Boolean) = updateState { copy(canShowModal = show) }
}
