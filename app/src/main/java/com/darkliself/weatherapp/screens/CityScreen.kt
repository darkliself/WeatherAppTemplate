package com.darkliself.weatherapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun CityScreen() {

    var txtValue by remember { mutableStateOf("") }
    Box() {
        TextField(value = txtValue, onValueChange = { txtValue = it })


    }
}


@Preview(showBackground = true)
@Composable
private fun defPreview() {
    CityScreen()
}