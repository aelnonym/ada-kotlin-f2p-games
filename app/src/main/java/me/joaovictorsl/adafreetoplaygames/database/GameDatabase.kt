package me.joaovictorsl.adafreetoplaygames.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import me.joaovictorsl.adafreetoplaygames.model.Game
import me.joaovictorsl.adafreetoplaygames.ui.Converters

@Database(entities = [Game::class], version = 1)
@TypeConverters(Converters::class)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object {
        private lateinit var INSTANCE: GameDatabase

        fun initialize(context: Context) {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    GameDatabase::class.java,
                    "game_database"
                ).build()
            }
        }

        fun getInstance(): GameDatabase {
            if (!::INSTANCE.isInitialized) throw IllegalStateException("Banco de dados não inicializado.")

            return INSTANCE
        }
    }
}