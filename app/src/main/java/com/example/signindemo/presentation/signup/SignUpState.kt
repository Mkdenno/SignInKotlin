package com.example.signindemo.presentation.signup

data class SignUpState (
    val  username: String="",
    val isUsernameError:Boolean=false,
    val  usernameError : String="",
    val email: String="",
    val isEmailError: Boolean=false,
    val emailError: String="",
    val password : String="",
    val isPasswordError :Boolean=false,
    val passwordError : String=""

)

