package com.darkliself.weatherapp.hourlyPOJO

data class Daily(
    val clouds: Int,
    val dt: Int,
    val feels_like: FeelsLike,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val snow: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val weather: List<Weather>,
    val wind_deg: Int,
    val wind_gust: Double,
    val wind_speed: Double
)