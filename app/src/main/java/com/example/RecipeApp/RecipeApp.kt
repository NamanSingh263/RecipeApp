package com.example.RecipeApp

import Category
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {
        composable(Screen.RecipeScreen.route) {
            RecipeScreen(navigateToDetails = {
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    "category",
                    it
                )
            navController.navigate(Screen.DetailScreen.route)
            }, viewState = viewState)
        }
        composable(Screen.DetailScreen.route){

            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")?:Category("","","","")
            CategoryDetailScreen(category = category)

        }

    }

}