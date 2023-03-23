package me.joaovictorsl.adafreetoplaygames.ui.gamelist

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

class GameListViewModel : ViewModel() {
    private val freeToGameService = getRetrofitInstance("https://www.freetogame.com/api/").create(FreeToGameService::class.java)

    private val _gameList = MutableLiveData<List<Game>>()
    val gameList: LiveData<List<Game>>
        get() = _gameList

    init {
        viewModelScope.launch {
            val res = freeToGameService.getAllGames()
            withContext(Dispatchers.Main) { _gameList.value = res }
        }
    }

}