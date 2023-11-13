package com.example.loginapp.data

import android.content.Context
import com.example.loginapp.data.local.SharedPreferenceManager
import com.example.loginapp.data.model.UserData
import com.example.loginapp.data.remote.ApiConfig


class LoginAppRepository(private val context: Context) {

    private val apiService = ApiConfig.apiService
    private val sharedPreferencesManager = SharedPreferenceManager(context)

    suspend fun postDataLogin(userData: UserData) = apiService.postDataLogin(userData)

    suspend fun getListUser(page: Int) = apiService.getListUser(2)

    fun saveTokenData(token: String){
        sharedPreferencesManager.saveTokenData(token)
    }

    fun getTokenData(): String?{
        return sharedPreferencesManager.getTokenData()
    }

    fun saveLoginData(username: String, password: String) {
        sharedPreferencesManager.saveLoginData(username, password)
    }

    fun getLoginData(): Pair<String, String>? {
        return sharedPreferencesManager.getLoginData()
    }

}