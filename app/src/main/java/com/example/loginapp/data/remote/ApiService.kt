package com.example.loginapp.data.remote

import com.example.loginapp.data.model.UserData
import com.example.loginapp.data.response.PostLoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun postDataLogin(
        @Body userData: UserData
    ): PostLoginResponse

}