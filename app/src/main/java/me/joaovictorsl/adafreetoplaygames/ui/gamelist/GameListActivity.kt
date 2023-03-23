package me.joaovictorsl.adafreetoplaygames.ui.gamelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import me.joaovictorsl.adafreetoplaygames.databinding.ActivityGameListBinding
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