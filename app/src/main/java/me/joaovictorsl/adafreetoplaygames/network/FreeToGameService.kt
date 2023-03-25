package me.joaovictorsl.adafreetoplaygames.network

import me.joaovictorsl.adafreetoplaygames.model.Game
import retrofit2.http.GET
import retrofit2.http.Query

interface FreeToGameService {

    @GET("games")
    suspend fun getAllGames(): List<Game>

    @GET("game")
    suspend fun getGameById(@Query("id") id: Int): Game

}