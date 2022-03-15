package com.darkliself.weatherapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.darkliself.weatherapp.Screen
import com.darkliself.weatherapp.retrofit_API.WeatherNetworkService
import kotlinx.coroutines.launch


@Composable
fun LoadingScreen(navController: NavController) {
    val context = LocalContext.current
    var city by remember { mutableStateOf("") }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1C99DF),
                        Color(0xFF32B5FF).copy(0.26f)
                    )
                )
            )
    ) {

        Column() {
            TextField(
                value = city,
                onValueChange = { city = it },
                singleLine = true
            )
            Button(onClick = {
                println("Find function")
//                scope.launch {
//                 scaffoldState.snackbarHostState.showSnackbar("hello")
//                }
                Toast.makeText(context, "show message", Toast.LENGTH_SHORT).show()

            }) {
                Text("Find city")
            }
        }

    }
    Text("Loading screen", Modifier.clickable {
        navController.navigate(Screen.MainScreen.route)
    })
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    LoadingScreen(NavController(LocalContext.current))
}