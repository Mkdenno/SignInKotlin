package com.example.signindemo.data.repository

import android.util.Log
import com.example.signindemo.data.HarryPotterApi
import com.example.signindemo.data.models.Data
import com.example.signindemo.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

interface CharacterListRepository {

    fun getCharacterList(): Flow<Resource<Data>>
    fun getCharacterDetail(id: String): Flow<Resource<Data>>
}

class CharacterListRepositoryImpl(
    private val api: HarryPotterApi
):CharacterListRepository{

    override fun getCharacterList(): Flow<Resource<List<Data>>> = flow{
        try{
            emit(Resource.Loading())

            val characters=api.getCharacters().data
            emit(Resource.Success(characters))

        } catch (e: Exception){
            emit(Resource.Error(e.message ?: "Something went wrong"))

        } catch (e : Exception){
            emit(Resource.Error(e.message ?: "Something went wrong"))

        } catch (e :IOException){
            emit(Resource.Error(e.message ?: "Could not Connect to Network"))

        }
    }

    override fun getCharacterDetail(id: String): Flow<Resource<Data>> = flow {
        try{
            emit(Resource.Loading())

            val characters=api.getCharacterDetail(id).data
            emit(Resource.Success(characters))

        } catch (e: Exception){
            emit(Resource.Error(e.message ?: "Something went wrong"))

        } catch (e : Exception){
            emit(Resource.Error(e.message ?: "Something went wrong"))

        } catch (e :IOException){
            emit(Resource.Error(e.message ?: "Could not Connect to Network"))

        }
    }
}