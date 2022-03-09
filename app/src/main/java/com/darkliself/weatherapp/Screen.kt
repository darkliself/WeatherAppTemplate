package com.darkliself.weatherapp

sealed class Screen(val route: String) {
    object LoadingScreen: Screen("loading_screen")
    object PresentationScreen: Screen("presentation_screen")
    object MainScreen: Screen("main_screen")
    object City: Screen("city_screen")
}