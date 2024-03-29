package com.example.signindemo.presentation.signin

data class SignInState(
    val username: String="",
    val isUsernameError :Boolean=false,
    val usernameError :String="",
    val password :String="",
    val isPasswordError:Boolean=false,
    val passwordError : String=""

)
