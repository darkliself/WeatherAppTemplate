package com.darkliself.weatherapp

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.darkliself.weatherapp.screens.CityScreen
import com.darkliself.weatherapp.screens.LoadingScreen
import com.darkliself.weatherapp.screens.MainScreen
import com.darkliself.weatherapp.screens.PresentationScreen
import java.util.*


@Composable
fun Navigation() {
    val materialBlue700= Color(0xFF1976D2)
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
//        topBar = { TopAppBar(title = {Text("TopAppBar")},backgroundColor = materialBlue700)  },
 //       floatingActionButtonPosition = FabPosition.End,
//        floatingActionButton = { FloatingActionButton(onClick = {}){
//            Text("X")
//        } },
        drawerContent = { Text(text = "drawerContent") },
        content = { NavigationScreens() },
 //        bottomBar = { BottomAppBar(backgroundColor = materialBlue700) { Text("BottomAppBar") } }
    )
}


@Composable
fun NavigationScreens() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoadingScreen.route) {
        composable(route = Screen.LoadingScreen.route) {
            LoadingScreen(navController = navController)
        }
        composable(route = Screen.PresentationScreen.route) {
            PresentationScreen(navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
        composable(route = Screen.City.route) {
            CityScreen()
        }
    }
}