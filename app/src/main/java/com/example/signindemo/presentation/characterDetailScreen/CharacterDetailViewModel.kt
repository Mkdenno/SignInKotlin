package com.example.signindemo.presentation.characterDetailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.signindemo.data.repository.CharacterListRepository
import com.example.signindemo.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharacterDetailViewModel (
private val characterListRepository: CharacterListRepository
): ViewModel() {

    private val _state = MutableStateFlow(CharacterDetailState())
            val state=_state.asStateFlow()

    fun getCharacterDetail(id: String) = viewModelScope.launch {
        characterListRepository.getCharacterDetail(id).collect{result ->
            when(result){
                is Resource.Error->{
                    _state.value= CharacterDetailState(
                        isLoading = false,
                        errorMessage = result.message
                    )
                }

                is Resource.Loading->{
                    _state.value=CharacterDetailState(
                        isLoading = true,
                    )
                }
                is Resource.Success->{
                    _state.value=CharacterDetailState(
                        isLoading = false,
                        data=result.data

                    )
                }

            }
        }

    }
}