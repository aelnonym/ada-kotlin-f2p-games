package me.joaovictorsl.adafreetoplaygames.ui.gamelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.joaovictorsl.adafreetoplaygames.repository.GameRepository

class GameListViewModelFactory (val repository: GameRepository) : ViewModelProvider.Factory  {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(GameListViewModel::class.java)){
            return GameListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
