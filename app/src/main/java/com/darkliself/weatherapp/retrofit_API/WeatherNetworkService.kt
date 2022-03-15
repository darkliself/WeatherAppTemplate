package com.darkliself.weatherapp.retrofit_API

import com.darkliself.weatherapp.hourlyPOJO.Forecast
import com.darkliself.weatherapp.weatherPOJO.MyWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


fun main(args: Array<String>) {

//    val t = listOf(1, 2, 3)
//    val z = t.let { it.reduce {a, b -> a - b} + 11} // { it -> it + 2 }
       //  WeatherNetworkService.getJSONWeather("kharkov")
    WeatherNetworkService.getForecast()
    //WeatherNetworkService.getStringForecast()
}

object WeatherNetworkService {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private const val API_KEY = "76bb42ac7cb89fc255ba962c7916dd20"
    private const val UNITS = "metric"

    // private val city = "kharkiv"

    fun getWeather(city: String): String {
        var result = ""
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(WeatherAPIInterface::class.java)
        val retrofitData = retrofitBuilder.getWeather(city, API_KEY)
        retrofitData.enqueue(object : Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                if (response.isSuccessful) {
                    println(response.body())
                    result = response.body().toString()
                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                println("its dead")
                println(t.message)
            }
        })
        return result
    }

    fun getJSONWeather(city: String) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(WeatherAPIInterface::class.java)
        val retrofitData = retrofitBuilder.getJSONWeather(city, UNITS, API_KEY)
        retrofitData.enqueue(object : Callback<MyWeather?> {
            override fun onResponse(call: Call<MyWeather?>, response: Response<MyWeather?>) {
                if (response.isSuccessful) {
                    println(response.body())
                }
            }

            override fun onFailure(call: Call<MyWeather?>, t: Throwable) {
                println("its dead")
                println(t.message)
            }
        })


    }

    fun getData(endPoint: String) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl("$BASE_URL$endPoint/")
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                if (response.isSuccessful) {
                    println(response.body())
                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
    fun getForecast() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(WeatherAPIInterface::class.java)
        val retrofitData = retrofitBuilder.getForecast( 50.0, 36.25, units = UNITS, appid = API_KEY)
        retrofitData.enqueue(object : Callback<Forecast?> {
            override fun onResponse(call: Call<Forecast?>, response: Response<Forecast?>) {
                if (response.isSuccessful) {
                    println("its here")
                    response.body()?.hourly?.take(5)?.forEach {
                        println(it)
                    }
                }
            }

            override fun onFailure(call: Call<Forecast?>, t: Throwable) {
                println("its dead")
                println(t.message)
            }
        })
    }
}