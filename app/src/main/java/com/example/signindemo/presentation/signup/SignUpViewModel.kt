package com.example.signindemo.presentation.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel : ViewModel() {
    private val _state= MutableStateFlow(SignUpState())
    val state=_state.asStateFlow()

    fun onUsernameChange(newValue: String){
        _state.value=_state.value.copy(
            username=newValue
        )
        if (_state.value.username.isNotEmpty()){
            _state.value=_state.value.copy(
                username="",
                isUsernameError=false

            )
        }


    }

    fun onEmailChange(newValue: String){
        _state.value=_state.value.copy(
            email = newValue
        )
        if (_state.value.email.isNotEmpty()){
            _state.value=_state.value.copy(
                email="",
                isEmailError=false
            )
        }

    }

    fun onPasswordChange(newValue: String){
        _state.value=_state.value.copy(
            password=newValue
        )
        if (_state.value.password.isNotEmpty()){
            _state.value=_state.value.copy(
                password = "",
                isPasswordError = false

            )
        }

    }

    fun SignUp(){
        if (_state.value.username.isBlank()){
            _state.value=_state.value.copy(
                usernameError= "Username cannot be blank",
                isUsernameError = true
            )
        }

        if (_state.value.email.isBlank()){
            _state.value=_state.value.copy(
                emailError = "Email cannot be blank",
                isEmailError = true
            )
        }

        if (_state.value.password.isBlank()){
            _state.value=_state.value.copy(
                passwordError = "Password cannot be blank",
                isPasswordError = true
            )
        }
    }


}