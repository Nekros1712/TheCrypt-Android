package com.example.thecrypt

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CryptoInterface {
    @GET("coins")
    fun getCrypts() : Call<List<Coins>>
}

object CryptoService {
    val cryptoInstance: CryptoInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        cryptoInstance = retrofit.create(CryptoInterface::class.java)
    }
}