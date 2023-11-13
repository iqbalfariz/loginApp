package com.example.loginapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.loginapp.data.LoginAppRepository
import com.example.loginapp.databinding.ActivityHomeBinding
import com.example.loginapp.viewmodel.HomeViewModel
import com.example.loginapp.viewmodel.ViewModelFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: ActivityHomeBinding

    companion object {
        const val DATA_TOKEN = "data_token"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModelFactory = ViewModelFactory(LoginAppRepository(this))
        homeViewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]

        val dataToken = intent.getStringExtra(DATA_TOKEN)
        if (dataToken != null){
//            Toast.makeText(applicationContext, "Selamat kamu berhasil login", Toast.LENGTH_SHORT).show()
        }
    }
}