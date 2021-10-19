package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.viewmodel.MainViewModel
import com.example.myapplication.viewmodel.MyViewModelFactory
import com.example.myapplication.R
import com.example.myapplication.retrofit.RetrofitService
import com.example.myapplication.repository.MainRepository

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)

        viewModel.claimList.observe(this, {
            Toast.makeText(this, it[1].claims.size, Toast.LENGTH_SHORT).show()
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer {
            Toast.makeText(this, "yes", Toast.LENGTH_SHORT).show()
        })

        viewModel.getAllClaims()

    }
}