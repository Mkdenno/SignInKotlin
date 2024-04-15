package com.example.signindemo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.signindemo.HarryPotterApp
import com.example.signindemo.presentation.characterDetailScreen.CharacterDetailScreen
import com.example.signindemo.presentation.characterDetailScreen.CharacterDetailViewModel
import com.example.signindemo.presentation.homescreen.HomeScreen
import com.example.signindemo.presentation.homescreen.HomeViewModel
import com.example.signindemo.presentation.homescreen.viewModelFactoryHelper
import com.example.signindemo.presentation.signin.SignInScreen
import com.example.signindemo.presentation.signin.SignInViewModel
import com.example.signindemo.presentation.signup.SignUpScreen
import com.example.signindemo.presentation.signup.SignUpViewModel

@Composable
fun Navigation(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = Screen.HomeScreen.route) {

        composable(route = Screen.SignInScreen.route) {
            val viewModel = viewModel<SignInViewModel>()
            SignInScreen(
                signInViewModel = viewModel,
                navigateToSignUp = {
                    navHostController.navigate(Screen.SignUpScreen.route)
                },
                navigateToHomeScreen = {
                    navHostController.navigate(Screen.HomeScreen.route) {
                        popUpTo(Screen.SignInScreen.route) {
                            inclusive = true
                        }
                    }

                }
            )
        }
        composable(route = Screen.SignUpScreen.route) {
            val viewModel = viewModel<SignUpViewModel>()
            SignUpScreen(
                signUpViewModel = viewModel,
                navigateBack = {
                    navHostController.popBackStack()
                },
                navigateToSignIn = {
                    navHostController.navigate(Screen.SignInScreen.route)
                }
            )
        }
        composable(route = Screen.HomeScreen.route) {
            val homeViewModel = viewModel<HomeViewModel>(
                factory = viewModelFactoryHelper {
                    HomeViewModel(HarryPotterApp.appModule.characterListRepository)

                }
            )
            HomeScreen(
                homeViewModel = homeViewModel,
                navigateToCharacterDetailScreen = { characterId ->
                    navHostController.navigate(
                        Screen.CharacterDetailScreen.navWithCharacterId(characterId)
                    )

                }
            )

        }

        composable(
            Screen.CharacterDetailScreen.withCharacterId(),
            arguments = listOf(
                navArgument("character_id") {
                    type = NavType.StringType
                }
            )


        ) {
            val characterDetailViewModel = viewModel<CharacterDetailViewModel>(
                factory = viewModelFactoryHelper {
                    CharacterDetailViewModel(
                        HarryPotterApp.appModule.characterListRepository
                    )

                }
            )

            val characterId = it.arguments?.getString("character_id")

            characterId?.let { id ->

                CharacterDetailScreen(
                    viewModel = characterDetailViewModel,
                    characterId = id
                )
            }


        }
    }
}

sealed class Screen(val route: String) {
    object SignInScreen : Screen("signing_screen")
    object SignUpScreen : Screen("signup_screen")
    object HomeScreen : Screen("home_screen")
    object CharacterDetailScreen : Screen("character_detail_screen")


    fun withCharacterId(): String {
        return "${CharacterDetailScreen.route}/{character_id}"
    }

    fun navWithCharacterId(id: String): String {
        return "${CharacterDetailScreen.route}/$id"
    }

}