package com.example.signindemo.presentation.signin

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
fun SignInScreen(
    signInViewModel: SignInViewModel,
    navigateToSignUp:()->Unit,
    navigateToHomeScreen:()->Unit
) {

    val state by signInViewModel.state.collectAsState()

//    var username by remember {mutableStateOf("")}
//    var password by remember {mutableStateOf("")}
    Column(modifier = Modifier
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
     Text(text = "SIGN IN", fontSize =28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier .height(8.dp))

        Input(label = "Username",
            placeholder ="Username" ,
            value =state.username,
            isError =state.isUsernameError,
            errorMessage = state.usernameError,
            onValueChange ={
            signInViewModel.onUsernameChange(it)
        } )

        Spacer(modifier = Modifier
            .height(8.dp)
        )

        PassWordInput(

            value = state.password,
            isError = state.isPasswordError,
            errorMessage= state.passwordError,
            onValueChange = {
           signInViewModel.onPasswordChange(it)
        })

        Spacer(modifier = Modifier
            .height(8.dp)
        )

        PrimaryButton(label = "SIGN IN") {
//            navigateToHomeScreen()
            signInViewModel.signIn()

        }
        Spacer(modifier = Modifier.height(.16.dp))

        Text(text = "Don't have an account? Sign Up",
            modifier = Modifier
                .clickable { navigateToSignUp() }
        )
    }

}