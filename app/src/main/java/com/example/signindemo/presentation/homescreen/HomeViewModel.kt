package com.example.signindemo.presentation.homescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.signindemo.data.repository.CharacterListRepository
import com.example.signindemo.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val characterListRepository: CharacterListRepository) : ViewModel(){

    private val _state= MutableStateFlow(HomState())
    val state=_state.asStateFlow()
    init {
        getCharacterList()
    }
    fun getCharacterList(){
        viewModelScope.launch{
            characterListRepository.getCharacterList().collect(){result->
                when(result){
                    is Resource.Loading->{
                        _state.value=HomState(
                            isLoading = true
                        )

                    }

                    is Resource.Error->{
                        _state.value=HomState(
                            isLoading = false,
                            errorMessage = result.message
                        )

                    }
                    is Resource.Success->{
                        _state.value=HomState(
                            isLoading = false,
                            data = result.data
                        )

                    }
                    
                }
            }

        }
    }

}
