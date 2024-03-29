package com.example.signindemo.data

import com.example.signindemo.data.models.CharacterDetailResponse
import com.example.signindemo.data.models.characterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HarryPotterApi {
    @GET("characters")
    suspend fun getCharacters(): characterResponse

    @GET("/characters/{id}")

    suspend fun getCharacterDetail(@Path("id") id: String): CharacterDetailResponse
}