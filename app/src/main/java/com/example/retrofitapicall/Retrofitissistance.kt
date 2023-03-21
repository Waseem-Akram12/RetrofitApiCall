package com.example.retrofitapicall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofitissistance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://dummyjson.com/products/").addConverterFactory(GsonConverterFactory.create()).build()
    }
    val Apiinterface by lazy {
        retrofit.create(RetrofitApi::class.java)
    }
}