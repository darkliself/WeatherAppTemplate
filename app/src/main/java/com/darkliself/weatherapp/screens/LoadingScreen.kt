package com.darkliself.weatherapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.darkliself.weatherapp.Screen


@Composable
fun LoadingScreen(navController: NavController) {
    Text("Loading screen", Modifier.clickable {
        navController.navigate(Screen.PresentationScreen.route)
    })
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    LoadingScreen(NavController(LocalContext.current))
}