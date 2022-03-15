package com.darkliself.weatherapp.hourlyPOJO

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

data class Forecast(
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Int,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)