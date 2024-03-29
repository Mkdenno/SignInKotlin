package com.example.signindemo.data

import com.example.signindemo.data.models.characterResponse
import retrofit2.http.GET

interface HarryPotterApi {
    @GET("characters")
    suspend fun getCharacters(): characterResponse

//    @GET("/characters/{id}")

//    suspend fun
}