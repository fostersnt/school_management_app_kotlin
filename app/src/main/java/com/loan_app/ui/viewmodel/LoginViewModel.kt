package com.loan_app.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loan_app.data.model.Post
import com.loan_app.data.model.PostPostData
import com.loan_app.data.repository.PostRepository
import kotlinx.coroutines.launch

class LoginViewModel () : ViewModel() {
    val msisdn = mutableStateOf("");

    fun onMsisdnChanged(newMsisdn: String) {
        msisdn.value = newMsisdn
        Log.i("LoginScreen", "CURRENT TEXT: $newMsisdn")
    }
}