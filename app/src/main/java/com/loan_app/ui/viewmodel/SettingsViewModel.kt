package com.loan_app.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    val msisdns = mutableStateListOf<String>();

    fun addMsisdn(msisdn: String) {
        if (msisdn.isNotBlank()) msisdns.add(msisdn)
    }

    fun removeMsisdn(msisdn: String) {
        msisdns.remove(msisdn)
    }
}
