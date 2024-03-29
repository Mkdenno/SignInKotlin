package com.example.signindemo.presentation.signin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignInViewModel : ViewModel(){

    private val _state= MutableStateFlow(SignInState())
    val state=_state.asStateFlow()

    fun onUsernameChange(newValue: String){
        _state.value=_state.value.copy(
            username=newValue
        )

        if (_state.value.username.isNotEmpty()){
            _state.value=_state.value.copy(
                usernameError = "",
                isUsernameError = false
            )
        }
    }


    fun onPasswordChange(newValue: String){
        _state.value=_state.value.copy(
            password=newValue

        )

        if (_state.value.password.isNotEmpty()){
            _state.value=_state.value.copy(
                passwordError = "",
                isPasswordError = false
            )
        }
    }
    fun  signIn(){
        if (_state.value.username.isBlank()){
            _state.value=_state.value.copy(
                usernameError = "Username Cannot be blank",
                isUsernameError = true
            )
        }

        if (_state.value.password.isBlank()){
            _state.value=_state.value.copy(
                passwordError = "Password Cannot be blank",
                isPasswordError = true
            )
        }
    }

}