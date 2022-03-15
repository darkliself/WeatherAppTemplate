package com.darkliself.weatherapp.screens

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.darkliself.weatherapp.R
import com.darkliself.weatherapp.retrofit_API.WeatherAPIInterface
import com.darkliself.weatherapp.retrofit_API.WeatherNetworkService
import org.intellij.lang.annotations.JdkConstants


@Composable
fun MainScreen() {
    val z = WeatherNetworkService.getWeather("kharkov")
    println(z)
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
                .fillMaxHeight(0.2f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

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
                Modifier.fillMaxWidth(0.6f)
            ) {
                Text("Roaming")
                Text("City Kharkov")
            }
        }

        Box(
            Modifier
                .fillMaxHeight(0.3f)
                .fillMaxWidth(0.5f)
                //.background(Color.Black)
                .align(BiasAlignment(0f, -0.3f))
                .zIndex(10f)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.cloud),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .align(BiasAlignment(0f, 0.55f))
                //.background(Color.Red)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("Tuesday")
                Text("02 January 2022")
                Text("06 43 AM")
                Text(text = z)
            }
        }

        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.16f)
                //.background(Color.Green)
                .align(BiasAlignment(0f, 1f))
        ) {
            Row(Modifier.fillMaxSize(),
                Arrangement.SpaceEvenly,
                Alignment.CenterVertically
                ) {
                Column() {
                    Text("Now")
                    Text("-27c")
                }
                Column() {
                    Text("06 00")
                    Text("-27c")
                }
                Column() {
                    Text("07 00")
                    Text("-27c")
                }
                Column() {
                    Text("08 00")
                    Text("-27c")
                }
                Column() {
                    Text("09 00")
                    Text("-27c")
                }
                Column() {
                    Text("10 00")
                    Text("-27c")
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun defPreview() {
    MainScreen()
}