package com.example.loginapp.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.loginapp.data.model.UserData

class SharedPreferenceManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE)

    fun saveTokenData(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString("token", token)
        editor.apply()
    }

    fun getTokenData(): String? {
        val token = sharedPreferences.getString("token", null)

        if (token != null) {
            return token
        }

        return null
    }

    fun saveLoginData(email: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
    }

    fun getLoginData(): Pair<String, String>? {
        val email = sharedPreferences.getString("email", null)
        val password = sharedPreferences.getString("password", null)

        if (email != null && password != null) {
            return Pair(email, password)
        }

        return null
    }

}