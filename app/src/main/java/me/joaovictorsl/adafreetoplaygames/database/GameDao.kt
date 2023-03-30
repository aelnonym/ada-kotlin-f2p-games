package me.joaovictorsl.adafreetoplaygames.database

import androidx.room.*
import me.joaovictorsl.adafreetoplaygames.model.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM games")
    suspend fun getAllGames(): List<Game>

    @Query("SELECT * FROM games WHERE id = :id")
    suspend fun getGameById(id: Int): Game?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: Game)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg games: Game)

    @Delete
    suspend fun deleteGame(game: Game)
}