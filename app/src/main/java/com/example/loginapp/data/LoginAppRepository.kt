package com.example.loginapp.data

import com.example.loginapp.data.model.UserData
import com.example.loginapp.data.remote.ApiConfig


class LoginAppRepository {

    private val apiService = ApiConfig.apiService

    suspend fun postDataLogin(userData: UserData) = apiService.postDataLogin(userData)

}