package me.joaovictorsl.adafreetoplaygames.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private const val BASE_URL = "https://www.freetogame.com/api/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: FreeToGameService by lazy {
        retrofit.create(FreeToGameService::class.java)
    }
}


