package com.darkliself.weatherapp.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController


@Composable
fun PresentationScreen(navController : NavController) {
    Text("Presentation screen")
}



@Preview(showBackground = true)
@Composable
private fun Preview() {
    PresentationScreen(NavController(LocalContext.current))
}