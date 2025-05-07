package com.loan_app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class LoanHistoryItem(
    val id: String,
    val amount: String,
    val status: LoanStatus,
    val term: String,
    val requestDate: String,
    val completedDate: String
)

enum class LoanStatus { APPROVED, REJECTED, PENDING }

class LoanHistoryViewModel : ViewModel() {

    private val _loanHistory = MutableStateFlow<List<LoanHistoryItem>>(emptyList())
    val loanHistory: StateFlow<List<LoanHistoryItem>> = _loanHistory

    init {
        loadDummyLoans()
    }

    private fun loadDummyLoans() {
        viewModelScope.launch {
            _loanHistory.value = listOf(
                LoanHistoryItem("1", "GHS 500", LoanStatus.APPROVED, "3 months", "2024-12-01", "2025-12-01"),
                LoanHistoryItem("2", "GHS 300", LoanStatus.REJECTED, "1 month", "2024-11-15", "2025-12-01"),
                LoanHistoryItem("3", "GHS 700", LoanStatus.PENDING, "6 months", "2025-01-10", "2025-12-01")
            )
        }
    }
}
