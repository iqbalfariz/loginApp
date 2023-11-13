package com.example.loginapp.data.remote

import com.example.loginapp.data.model.UserData
import com.example.loginapp.data.response.ListUserResponse
import com.example.loginapp.data.response.PostLoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("login")
    suspend fun postDataLogin(
        @Body userData: UserData
    ): PostLoginResponse

    @GET("users")
    suspend fun getListUser(
        @Query("page") page: Int
    ): ListUserResponse

}