package com.example.retrofitapicall

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {
    @GET("1")
    fun getData():Call<nextnewone>
}