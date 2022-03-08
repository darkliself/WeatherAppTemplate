package com.darkliself.weatherapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.darkliself.weatherapp.screens.LoadingScreen
import com.darkliself.weatherapp.screens.MainScreen
import com.darkliself.weatherapp.screens.PresentationScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.LoadingScreen.route) {
            LoadingScreen(navController = navController)
        }
        composable(route = Screen.PresentationScreen.route) {
            PresentationScreen(navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
    }
}