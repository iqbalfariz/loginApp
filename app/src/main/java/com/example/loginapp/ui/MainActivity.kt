package com.example.loginapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.loginapp.R
import com.example.loginapp.data.LoginAppRepository
import com.example.loginapp.data.model.UserData
import com.example.loginapp.databinding.ActivityMainBinding
import com.example.loginapp.viewmodel.MainViewModel
import com.example.loginapp.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModelFactory = ViewModelFactory(LoginAppRepository())
        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            sendDataLogin(email, password)
        }

        mainViewModel.responseDataLogin.observe(this){
            println("result post : $it")
        }
    }

    private fun sendDataLogin(email: String, password: String) {
        val userData = UserData(
            email = email,
            password = password
        )
        mainViewModel.postDataLogin(userData)
    }
}