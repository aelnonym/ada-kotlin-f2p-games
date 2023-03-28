package me.joaovictorsl.adafreetoplaygames.ui.gamelist

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.joaovictorsl.adafreetoplaygames.model.Game
import me.joaovictorsl.adafreetoplaygames.model.GameRepository

class GameListViewModel (private val repository: GameRepository) : ViewModel() {

    private val _gameList = MutableLiveData<List<Game>>()
    val gameList: LiveData<List<Game>>
        get() = _gameList

    init {
        viewModelScope.launch {
            val res = repository.getGames()
            withContext(Dispatchers.Main) { _gameList.value = res }
        }
    }

}