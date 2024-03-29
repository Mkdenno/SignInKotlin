package com.example.signindemo.di

import android.content.Context
import com.example.signindemo.data.HarryPotterApi
import com.example.signindemo.data.repository.CharacterListRepository
import com.example.signindemo.data.repository.CharacterListRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface AppModule {

    val  api : HarryPotterApi
    val characterListRepository: CharacterListRepository

}

class AppModuleImpl(
//    val context :Context
): AppModule{
    override val api: HarryPotterApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://api.potterdb.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
    override val characterListRepository: CharacterListRepository by lazy {
        CharacterListRepositoryImpl(api)
    }


}