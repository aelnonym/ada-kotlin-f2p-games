package me.joaovictorsl.adafreetoplaygames.ui.gamedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GameDetailViewModelFactory(private val gameId: Int) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameDetailViewModel::class.java)) {
            return GameDetailViewModel(gameId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}