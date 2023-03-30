package me.joaovictorsl.adafreetoplaygames.repository

import android.util.Log
import me.joaovictorsl.adafreetoplaygames.database.GameDao
import me.joaovictorsl.adafreetoplaygames.database.GameDatabase
import me.joaovictorsl.adafreetoplaygames.model.Game
import me.joaovictorsl.adafreetoplaygames.network.FreeToGameService
import me.joaovictorsl.adafreetoplaygames.network.RetrofitInstance
import me.joaovictorsl.adafreetoplaygames.network.getRetrofitInstance

class GameRepository {
    private val freeToGameService = RetrofitInstance.api
    private val gameDao = GameDatabase.getInstance().gameDao()

    private suspend fun getGamesFromDatabase(): List<Game> {
        Log.d("GameRepository", "Fetching games from the database")
        return gameDao.getAllGames()
    }

    private suspend fun getGamesFromApiAndSaveToDatabase() {
        val games = freeToGameService.getAllGames()
        gameDao.insertAll(*games.toTypedArray())
        Log.d("GameRepository", "Games saved to the database")
    }

    suspend fun getGameById(id: Int): Game? {
        return gameDao.getGameById(id)
    }

    suspend fun getGames(): List<Game> {
        val gamesFromDatabase = getGamesFromDatabase()

        if(gamesFromDatabase.isNotEmpty()){
            Log.d("GameRepository", "DB com coisas ${gamesFromDatabase.first().title}")
        }
        else {
            Log.d("GameRepository", "DB Vazia")
        }
        return if (gamesFromDatabase.isNotEmpty()) {
        gamesFromDatabase
        } else {
            getGamesFromApiAndSaveToDatabase()
            getGamesFromDatabase()
        }
    }
}