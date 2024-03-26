package com.example.signindemo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.signindemo.homescreen.HomeScreen
import com.example.signindemo.signin.SignInScreen
import com.example.signindemo.signup.SignUpScreen

@Composable
fun Navigation(
    navHostController : NavHostController
) {
    NavHost(navController = navHostController, startDestination = Screen.SignInScreen.route) {

        composable(route=Screen.SignInScreen.route){
            SignInScreen(
                navigateToSignUp = {
                                   navHostController.navigate(Screen.SignUpScreen.route)
                },
                navigateToHomeScreen = {
                    navHostController.navigate(Screen.HomeScreen.route){
                        popUpTo(Screen.SignInScreen.route){
                            inclusive=true
                        }
                    }

                }
            )
        }
        composable(route=Screen.SignUpScreen.route){
            SignUpScreen(
                navigateBack = {
                    navHostController.popBackStack()

                }
            )
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen()

        }

        
    }
    
}
sealed class Screen(val route: String){
    object SignInScreen: Screen("signing_screen")
    object SignUpScreen: Screen("signup_screen")
    object HomeScreen: Screen("home_screen")

}