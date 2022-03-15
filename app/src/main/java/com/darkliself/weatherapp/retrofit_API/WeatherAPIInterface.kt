package com.darkliself.weatherapp.retrofit_API

import com.darkliself.weatherapp.hourlyPOJO.Forecast
import com.darkliself.weatherapp.weatherPOJO.MyWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIInterface {

    // @GET("weather?q=kharkiv&appid=76bb42ac7cb89fc255ba962c7916dd20")
    @GET("weather/")
    fun getWeather(
        @Query("q") q: String,
        // @Query("units") units: String,
        @Query("appid") appid: String,
    ): Call<String>

    @GET("weather/")
    fun getJSONWeather(
        @Query("q") q: String,
        @Query("units") units: String,
        // @Query("units") units: String,
        @Query("appid") appid: String,
    ): Call<MyWeather>

    @GET("onecall")
    fun getForecast(

        @Query("lat") lat: Double = 50.0,
        @Query("lon") lon: Double = 36.25,
        // metric|imperial|standard
        @Query("units") units: String,
        // values minutely|hourly|daily|current|alerts
       // @Query("exclude") exclude: String = "",
        // @Query("units") units: String,
        @Query("appid") appid: String
    ): Call<Forecast>


    @GET("onecall")
    fun getStringForecast(
        // @Query("q") q: String,
        // lat=50&lon=36.25
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        // metric|imperial|standard
        @Query("units") units: String,
        // values minutely|hourly|daily|current|alerts
        // @Query("exclude") exclude: String = "",
        // @Query("units") units: String,
        @Query("appid") appid: String
    ): Call<String>
}
