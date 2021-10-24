package com.jeff.retrofit.repository

import com.jeff.retrofit.model.Quote
import com.jeff.retrofit.retrofit.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun getQuote(): Response<Quote>{
        return RetrofitInstance.api.getQuote()
    }

}