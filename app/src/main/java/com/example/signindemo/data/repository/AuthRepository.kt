package com.example.signindemo.data.repository

import com.example.signindemo.data.models.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow

interface AuthRepository{
    val currentUserId: String
    val hasUser: Boolean

    val currentUser: Flow<User>

    suspend fun authenticate( email:String, password:String): User

    suspend fun createAccount(username:String, email:String, password: String): String?

    suspend fun signOut()

}

class AuthRepositoryImpl(
    private val auth: FirebaseAuth
):AuthRepository {
    override val currentUserId: String
        get() = TODO("Not yet implemented")
    override val hasUser: Boolean
        get() = TODO("Not yet implemented")
    override val currentUser: Flow<User>
        get() = TODO("Not yet implemented")

    override suspend fun authenticate( email: String, password: String): User {
        TODO("Not yet implemented")
    }

    override suspend fun createAccount(username: String, email: String, password: String): String? {
        TODO("Not yet implemented")
    }

    override suspend fun signOut() {
        TODO("Not yet implemented")
    }
}