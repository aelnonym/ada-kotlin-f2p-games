package me.joaovictorsl.adafreetoplaygames.ui.gamelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import me.joaovictorsl.adafreetoplaygames.databinding.ActivityGameListBinding
import me.joaovictorsl.adafreetoplaygames.database.GameDao
import me.joaovictorsl.adafreetoplaygames.database.GameDatabase
import me.joaovictorsl.adafreetoplaygames.repository.GameRepository
import me.joaovictorsl.adafreetoplaygames.ui.recyclerview.adapter.GameAdapter




class GameListActivity : AppCompatActivity() {

    private lateinit var dao : GameDao
    private lateinit var gameRepository : GameRepository
    private lateinit var factory : GameListViewModelFactory
    private lateinit var viewModel: GameListViewModel

    private val binding by lazy { ActivityGameListBinding.inflate(layoutInflater) }
    private val rvGameList by lazy { binding.gameListRecyclerView }
    private val gameListAdapter = GameAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GameDatabase.initialize(applicationContext)
        setContentView(binding.root)

        configViewModel()
        configRecyclerView()
    }

    private fun configViewModel() {
        gameRepository = GameRepository()
        factory = GameListViewModelFactory(gameRepository)

        viewModel = ViewModelProvider(this, factory)[GameListViewModel::class.java]

        viewModel.gameList.observe(this) { updatedGameList ->
            gameListAdapter.setNewList(updatedGameList)
        }

    }

    private fun configRecyclerView() {
        rvGameList.adapter = gameListAdapter
        rvGameList.layoutManager = LinearLayoutManager(this)
        Log.d("GameListActivity", "configRecyclerView() started")

    }
}