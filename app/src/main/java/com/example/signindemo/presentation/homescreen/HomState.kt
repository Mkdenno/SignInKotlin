package com.example.signindemo.presentation.homescreen

import com.example.signindemo.data.models.Data

data class HomState(
    val isLoading: Boolean=false,
    val data: List<Data> = emptyList(),
    val errorMessage: String=""
)
