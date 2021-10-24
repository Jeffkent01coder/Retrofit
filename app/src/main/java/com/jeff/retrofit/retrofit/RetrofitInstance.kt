package com.jeff.retrofit.retrofit

import com.jeff.retrofit.aPIServices.KanyeApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.kanye.rest")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: KanyeApi by lazy {
        retrofit.create(KanyeApi::class.java)
    }
}