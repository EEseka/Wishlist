package com.example.wishlist

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Add : Screen("profile")
}