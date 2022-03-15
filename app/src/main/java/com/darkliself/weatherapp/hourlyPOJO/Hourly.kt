package com.darkliself.weatherapp.hourlyPOJO

data class Hourly(
    val clouds: String,
    val dt: String,
    val feels_like: String,
    val humidity: String,
    val pop: String,
    val pressure: String,
    val temp: String,
    val weather: List<Weather>,
    val wind_deg: String,
    val wind_gust: String,
    val wind_speed: String
)