package com.darkliself.weatherapp.screens

import android.graphics.drawable.GradientDrawable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MainScreen() {
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
        // Header

        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)

        ) {
            Text("20C")
            // Divider(color = Color.Black, thickness = 2.dp, modifier = Modifier.rotate(90f).border(width = 20.dp, Color.Black))

            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp)
            )
            Row(
                Modifier.fillMaxSize()
            ) {
                Text("Roaming")
                Text("City Kharkov")
            }
        }

        Box(
            Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth(0.5f)
                .background(Color.Black)
                .align(BiasAlignment(0f, 0f))
        ) {

        }

    }
}


@Preview(showBackground = true)
@Composable
private fun defPreview() {
    MainScreen()
}