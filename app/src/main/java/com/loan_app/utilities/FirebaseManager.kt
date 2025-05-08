package com.loan_app.utilities

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging

object FirebaseTokenManager {
    fun getDeviceToken() {
//    fun getDeviceToken(onTokenReceived: (String) -> Unit) {
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val token = task.result
                    Log.i("FCM", "Token: $token")
                    //SEND THE DEVICE TOKEN TO YOUR BACK-END AND STORE IT FOR IDENTIFICATION
//                    onTokenReceived(token)
                } else {
                    Log.i("FCM", "Fetching FCM token failed", task.exception)
                }
            }
    }
}
