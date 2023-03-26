package me.joaovictorsl.adafreetoplaygames.ui.gamelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import me.joaovictorsl.adafreetoplaygames.databinding.ActivityGameListBinding
import me.joaovictorsl.adafreetoplaygames.model.Game
import me.joaovictorsl.adafreetoplaygames.model.GameDatabase
import me.joaovictorsl.adafreetoplaygames.network.RetrofitInstance
import me.joaovictorsl.adafreetoplaygames.ui.recyclerview.adapter.GameAdapter


class GameListActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this)[GameListViewModel::class.java] }
    private val binding by lazy { ActivityGameListBinding.inflate(layoutInflater) }
    private val rvGameList by lazy { binding.gameListRecyclerView }
    private val gameListAdapter = GameAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configViewModel()
        configRecyclerView()

        lifecycleScope.launch {
            // Cria uma instância de GameDao
            val dao = GameDatabase.getInstance(applicationContext).gameDao()

            // Faz a chamada à API e obtenha a lista de jogos
            val games = RetrofitInstance.api.getAllGames()

            // Converta cada objeto Game em um objeto GameEntity e insira na database
            games.forEach { game ->
                val game = Game(
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
                dao.insertGame(game)
            }
        }

    }

    private fun configViewModel() {
        viewModel.gameList.observe(this) { updatedGameList ->
            gameListAdapter.setNewList(updatedGameList)
        }
    }

    private fun configRecyclerView() {
        rvGameList.adapter = gameListAdapter
        rvGameList.layoutManager = LinearLayoutManager(this)
    }
}