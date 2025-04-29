package com.loan_app.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class LoginViewModel () : ViewModel() {
//    val msisdn = mutableStateOf("");
    val msisdn = MutableLiveData("");

    fun onMsisdnChanged(newMsisdn: String) {
        msisdn.value = newMsisdn
        Log.i("LoginViewModel", "CURRENT TEXT: $newMsisdn")
    }

    /*
    This function returns the msisdn state variable in a form that cannot be changed inside the view
    NOTE: MutableLiveData allows state variables to be change whereas LiveData does not
    */
    fun  getMsisdn(): LiveData<String>{
        return msisdn;
    }

    fun otpTrigger(): Unit{
        Log.i("OTP TRIGGER", "User phone number === ${msisdn.value}")
    }
}