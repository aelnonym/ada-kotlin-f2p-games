package me.joaovictorsl.adafreetoplaygames.model

import android.util.Log
import me.joaovictorsl.adafreetoplaygames.network.FreeToGameService

class GameRepository(private val gameDao: GameDao, private val freeToGameService: FreeToGameService) {

    private suspend fun getGamesFromDatabase(): List<Game> {
        Log.d("GameRepository", "Fetching games from the database")
        return gameDao.getAllGames()
    }

    private suspend fun getGamesFromApiAndSaveToDatabase() {
        val games = freeToGameService.getAllGames()
        val gameEntities = games.map { game ->
            Game(
                id = game.id,
                title = game.title,
                thumbnail = game.thumbnail,
                shortDescription = game.shortDescription,
                gameUrl = game.gameUrl,
                genre = game.genre,
                platform = game.platform,
                publisher = game.publisher,
                developer = game.developer,
                releaseDate = game.releaseDate,
                freetogameProfileUrl = game.freetogameProfileUrl
            )
        }
        gameDao.insertAll(gameEntities)
        Log.d("GameRepository", "Games saved to the database")
    }

    suspend fun getGameById(id: Int): Game? {
        return gameDao.getGameById(id)
    }

    suspend fun getGames(): List<Game> {
        val gamesFromDatabase = getGamesFromDatabase()
        if(gamesFromDatabase.isNotEmpty()){
            Log.d("GameRepository", "DB Vazia")
        }
        else {
            Log.d("GameRepository", "DB com coisas ${gamesFromDatabase.first().title}")
        }
            return if (gamesFromDatabase.isNotEmpty()) {
            gamesFromDatabase
        } else {
            getGamesFromApiAndSaveToDatabase()
            getGamesFromDatabase()
        }
    }
}