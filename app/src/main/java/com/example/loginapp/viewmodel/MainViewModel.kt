package com.example.loginapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapp.data.LoginAppRepository
import com.example.loginapp.data.model.UserData
import com.example.loginapp.data.response.PostLoginResponse
import kotlinx.coroutines.launch

class MainViewModel(private val repository: LoginAppRepository): ViewModel() {

    val responseDataLogin = MutableLiveData<PostLoginResponse>()
    fun postDataLogin(userData: UserData) {
        viewModelScope.launch {
            responseDataLogin.value = repository.postDataLogin(userData)
        }
    }

}