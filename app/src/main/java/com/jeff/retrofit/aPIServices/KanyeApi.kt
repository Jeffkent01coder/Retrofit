package com.jeff.retrofit.aPIServices

import com.jeff.retrofit.model.Quote
import retrofit2.Response
import retrofit2.http.GET

interface KanyeApi {
    @GET("/")
    suspend fun getQuote(): Response<Quote>
}