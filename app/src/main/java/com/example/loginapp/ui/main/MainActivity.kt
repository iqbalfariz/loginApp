package com.example.loginapp.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.loginapp.data.LoginAppRepository
import com.example.loginapp.data.model.UserData
import com.example.loginapp.databinding.ActivityMainBinding
import com.example.loginapp.ui.home.HomeActivity
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
        viewModelFactory = ViewModelFactory(LoginAppRepository(this))
        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        if (mainViewModel.isUserLoggedIn()){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            binding.btnLogin.setOnClickListener {
                val email = binding.etEmail.text.toString()
                val password = binding.etPassword.text.toString()
                sendDataLogin(email, password)
            }
        }

        mainViewModel.responseDataLogin.observe(this){
            println("result post : $it")
            if (it != null){
                mainViewModel.saveTokenData(it.token)
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra(HomeActivity.DATA_TOKEN, it.token)
                startActivity(intent)
                finish()
                Toast.makeText(applicationContext, "Selamat kamu berhasil login", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Data yang kamu masukkan salah", Toast.LENGTH_LONG).show()
            }
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