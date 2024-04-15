package com.example.signindemo.presentation.characterDetailScreen

import com.example.signindemo.data.models.Data

data class CharacterDetailState(
    val isLoading: Boolean =false,
    val data: Data? =null,
    val errorMessage: String=""
)
