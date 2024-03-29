package com.example.signindemo.presentation.homescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.signindemo.data.repository.CharacterListRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val characterListRepository: CharacterListRepository) : ViewModel(){

    init {
        getCharacterList()
    }
    fun getCharacterList(){
        viewModelScope.launch{
            characterListRepository.getCharacterList().collect(){
                Log.i("characters", it.toString())
            }

        }
    }

}
