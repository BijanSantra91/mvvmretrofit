package com.example.myapplication.repository

import com.example.myapplication.retrofit.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllClaims() = retrofitService.getAllClaimsData()

}