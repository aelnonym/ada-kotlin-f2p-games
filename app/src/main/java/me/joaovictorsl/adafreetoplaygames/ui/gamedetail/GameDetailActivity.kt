package me.joaovictorsl.adafreetoplaygames.ui.gamedetail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import me.joaovictorsl.adafreetoplaygames.R
import me.joaovictorsl.adafreetoplaygames.databinding.ActivityGameDetailBinding
import me.joaovictorsl.adafreetoplaygames.model.Game
import me.joaovictorsl.adafreetoplaygames.ui.SeeMoreTextViewClickListener
import me.joaovictorsl.adafreetoplaygames.ui.gamedetail.screenshotcarrousel.ScreenshotCarrouselFragment

class GameDetailActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this, GameDetailViewModelFactory(game.id))[GameDetailViewModel::class.java] }
    private val binding by lazy { ActivityGameDetailBinding.inflate(layoutInflater) }
    private val carrouselFragment by lazy { ScreenshotCarrouselFragment.newInstance() }
    private lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        game = getGameFromExtra()

        configViewModel()
        setClickListeners()
        setFragment()
        setGameInfoIntoView()
    }

    private fun configViewModel() {
        viewModel.game.observe(this) { updatedGame ->
            game = updatedGame
            setGameInfoIntoView()
            carrouselFragment.setScreenshotList(game.screenshots)
        }
    }

    private fun setClickListeners() {
        binding.gameDetailInfoSection.apply {
            tvDescriptionSeeMore.setOnClickListener(SeeMoreTextViewClickListener(tvDescription))
        }
    }

    private fun setFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(binding.screenshotCarrouselFragment.id, carrouselFragment)
        fragmentTransaction.commit()
    }

    private fun setGameInfoIntoView() {
        binding.gameDetailInfoSection.apply {
            tvTitle.text = game.title
            tvDescription.text = game.description
            tvDeveloper.text = getString(R.string.detail_developer, game.developer)
            tvGenre.text = getString(R.string.detail_genre, game.genre)
            tvPlatform.text = getString(R.string.detail_platform, game.platform)
            tvPublisher.text = getString(R.string.detail_publisher, game.publisher)
            tvReleaseDate.text = getString(R.string.detail_release_date, game.releaseDate)
            tvStatus.text = getString(R.string.detail_status, game.status)
            tvOs.text = getString(R.string.detail_os, game.minSystemReq.os)
            tvProcessor.text = getString(R.string.detail_processor, game.minSystemReq.processor)
            tvMemory.text = getString(R.string.detail_memory, game.minSystemReq.memory)
            tvGraphics.text = getString(R.string.detail_graphics, game.minSystemReq.graphics)
            tvStorage.text = getString(R.string.detail_storage, game.minSystemReq.storage)
        }

        Glide.with(this)
            .load(game.thumbnail)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(binding.gameDetailThumbnail)
    }

    private fun getGameFromExtra(): Game {
        val game = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            intent.extras?.getParcelable(getString(R.string.game_extra_key), Game::class.java)
        else
            intent.extras?.getParcelable(getString(R.string.game_extra_key)) as Game?

        return game ?: Game()
    }

}