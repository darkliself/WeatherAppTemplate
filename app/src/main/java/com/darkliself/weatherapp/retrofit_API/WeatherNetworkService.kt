package com.darkliself.weatherapp.retrofit_API

import com.darkliself.weatherapp.weatherPOJO.MyWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


fun main(args: Array<String>) {
    WeatherNetworkService.getWeather("kharkov")
    WeatherNetworkService.getJSONWeather("kharkov")
    val t = listOf(1, 2, 3)
    val z = t.let { it.reduce {a, b -> a - b} + 11} // { it -> it + 2 }
    println(z)
}

object WeatherNetworkService {
    private val BaseURL = "https://api.openweathermap.org/data/2.5/"
    private val apiKey = "76bb42ac7cb89fc255ba962c7916dd20"
    private val UNITS = "metric"

    // private val city = "kharkiv"

    fun getWeather(city: String): String {
        var result = ""
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl(BaseURL)
            .build()
            .create(WeatherAPIInterface::class.java)
        val retrofitData = retrofitBuilder.getWeather(city, apiKey)
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
            .baseUrl(BaseURL)
            .build()
            .create(WeatherAPIInterface::class.java)
        val retrofitData = retrofitBuilder.getJSONWeather(city, UNITS, apiKey)
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

//    fun testPlanIO() {
//        val retrofitBuilder = Retrofit.Builder()
//            .addConverterFactory(ScalarsConverterFactory.create())
//            .baseUrl(BaseURL)
//            .build()
//            .create(ApiInterface::class.java)
//        val retrofitData = retrofitBuilder.getData()
//
//        retrofitData.enqueue(object : Callback<String?> {
//            override fun onResponse(call: Call<String?>, response: Response<String?>) {
//                if (response.isSuccessful) {
//                    println(response.body())
//                } else {
//                    println(response.message())
//                }
//            }
//            override fun onFailure(call: Call<String?>, t: Throwable) {
//                println(t.message)
//            }
//        })
//    }

    fun getData(endPoint: String) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl("$BaseURL$endPoint/")
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
}