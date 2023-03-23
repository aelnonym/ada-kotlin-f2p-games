package me.joaovictorsl.adafreetoplaygames.network

import me.joaovictorsl.adafreetoplaygames.model.Game
import retrofit2.http.GET

interface FreeToGameService {

    @GET("games")
    suspend fun getAllGames(): List<Game>

}