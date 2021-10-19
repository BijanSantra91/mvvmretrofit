package com.example.myapplication.retrofit

import Json4Kotlin_Base
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("claims_json.json")
    suspend fun getAllClaimsData() : Response<Json4Kotlin_Base>

    companion object {
        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://s3.ap-southeast-1.amazonaws.com/files.mobisy.com/bourbon/TEST/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}