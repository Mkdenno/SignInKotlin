package com.example.signindemo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.signindemo.HarryPotterApp
import com.example.signindemo.presentation.homescreen.HomeScreen
import com.example.signindemo.presentation.homescreen.HomeViewModel
import com.example.signindemo.presentation.homescreen.viewModelFactoryHelper
import com.example.signindemo.presentation.signin.SignInScreen
import com.example.signindemo.presentation.signin.SignInViewModel
import com.example.signindemo.presentation.signup.SignUpScreen
import com.example.signindemo.presentation.signup.SignUpViewModel

@Composable
fun Navigation(
    navHostController : NavHostController
) {
    NavHost(navController = navHostController, startDestination = Screen.HomeScreen.route) {

        composable(route= Screen.SignInScreen.route){
            val viewModel=viewModel<SignInViewModel>()
            SignInScreen(
                signInViewModel = viewModel,
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
        composable(route= Screen.SignUpScreen.route){
            val viewModel= viewModel<SignUpViewModel>()
            SignUpScreen(
                signUpViewModel =viewModel,
                navigateBack = {
                    navHostController.popBackStack()

                },
                navigateToSignIn={
                    navHostController.navigate(Screen.SignInScreen.route)
                }
            )
        }
        composable(route = Screen.HomeScreen.route){
            val homeViewModel= viewModel<HomeViewModel>(
                factory = viewModelFactoryHelper {
                    HomeViewModel(HarryPotterApp.appModule.characterListRepository)

                }
            )
            HomeScreen(
                homeViewModel = homeViewModel
            )

        }

        
    }
    
}
sealed class Screen(val route: String){
    object SignInScreen: Screen("signing_screen")
    object SignUpScreen: Screen("signup_screen")
    object HomeScreen: Screen("home_screen")

}