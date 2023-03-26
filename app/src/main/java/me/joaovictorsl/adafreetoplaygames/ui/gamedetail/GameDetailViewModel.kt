package me.joaovictorsl.adafreetoplaygames.ui.gamedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.joaovictorsl.adafreetoplaygames.model.Game
import me.joaovictorsl.adafreetoplaygames.network.FreeToGameService
import me.joaovictorsl.adafreetoplaygames.network.getRetrofitInstance

class GameDetailViewModel(private val gameId: Int) : ViewModel() {
    private val freeToGameService = getRetrofitInstance("https://www.freetogame.com/api/").create(FreeToGameService::class.java)

    private val _game = MutableLiveData<Game>()
    val game: LiveData<Game>
        get() = _game

    init {
        viewModelScope.launch {
            val res = freeToGameService.getGameById(gameId)
            withContext(Dispatchers.Main) { _game.value = res }
        }
    }

}
