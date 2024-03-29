package com.example.signindemo.presentation.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signindemo.presentation.components.Input
import com.example.signindemo.presentation.components.PassWordInput
import com.example.signindemo.presentation.components.PrimaryButton

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel,
    navigateBack:()->Unit,
    navigateToSignIn:()->Unit

) {
//    var username by remember{mutableStateOf( "")}
//    var email by remember{ mutableStateOf( "") }
//    var password by remember{ mutableStateOf( "") }
    val state by signUpViewModel.state.collectAsState()
    Column(modifier = Modifier

        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Create Account", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Input(label = "Username",
            placeholder ="Username" ,
            value =state.username,
            isError =state.isUsernameError,
            errorMessage = state.usernameError,
            onValueChange ={
                signUpViewModel.onUsernameChange(it)
            } )

        Spacer(modifier = Modifier
            .height(8.dp)
        )

        Input(
            label = "Email",
            placeholder ="Email",
            isError = state.isEmailError, errorMessage = state.emailError, value =state.email , onValueChange ={

            signUpViewModel.onEmailChange(it)
        } )

        Spacer(modifier = Modifier
            .height(8.dp)
        )
        PassWordInput(
            value =state.password ,
            isError = state.isPasswordError,
            errorMessage = state.passwordError, onValueChange = {
            signUpViewModel.onPasswordChange(it)
        })

        Spacer(modifier = Modifier
            .height(8.dp)
        )

        PrimaryButton(label = "SignUp") {
//            navigateBack()
            signUpViewModel.SignUp()

        }
        Spacer(modifier = Modifier.height(.16.dp))

        Text(text = "Don't have an account? Sign Up",
            modifier = Modifier
                .clickable { navigateToSignIn() }
        )


    }
}