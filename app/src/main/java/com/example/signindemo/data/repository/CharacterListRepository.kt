package com.example.signindemo.data.repository

import android.util.Log
import com.example.signindemo.data.HarryPotterApi
import com.example.signindemo.data.models.Data
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface CharacterListRepository {

    fun getCharacterList(): Flow<List<Data>>
}

class CharacterListRepositoryImpl(
    private val api: HarryPotterApi
):CharacterListRepository{

    override fun getCharacterList(): Flow<List<Data>> = flow {
        try{
            val characters=api.getCharacters().data
            emit(characters)

        } catch (e: Exception){
            Log.d("Exception", e.toString())

        } catch (e : Exception){
            Log.d("Exception", e.toString())


        } catch (e :Exception){
            Log.d("Exception", e.toString())

        }
    }

}