package me.joaovictorsl.adafreetoplaygames.ui.gamedetail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import me.joaovictorsl.adafreetoplaygames.R
import me.joaovictorsl.adafreetoplaygames.databinding.ActivityGameDetailBinding
import me.joaovictorsl.adafreetoplaygames.model.Game

class GameDetailActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this, GameDetailViewModelFactory(game.id))[GameDetailViewModel::class.java] }
    private lateinit var game: Game
    private val binding by lazy { ActivityGameDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        game = getGameFromExtra()

        configViewModel()
    }

    private fun getGameFromExtra(): Game {
        val game = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            intent.extras?.getParcelable(getString(R.string.game_extra_key), Game::class.java)
        else
            intent.extras?.getParcelable(getString(R.string.game_extra_key)) as Game?

        return game ?: Game()
    }

    private fun configViewModel() {
        viewModel.game.observe(this) { updatedGame ->
            game = updatedGame
        }
    }
}