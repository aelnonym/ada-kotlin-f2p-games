package me.joaovictorsl.adafreetoplaygames.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getRetrofitInstance(url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}