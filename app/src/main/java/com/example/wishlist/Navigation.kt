package com.example.wishlist

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(viewModel: WishViewModel = viewModel(), navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeView(navController, viewModel)
        }
        composable(route = Screen.Add.route) {
            AddEditDetailView(0L, viewModel, navController)
        }
    }
}