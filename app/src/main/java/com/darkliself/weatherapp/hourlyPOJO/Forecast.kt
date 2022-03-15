package com.darkliself.weatherapp.hourlyPOJO

data class Forecast(
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Int,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)