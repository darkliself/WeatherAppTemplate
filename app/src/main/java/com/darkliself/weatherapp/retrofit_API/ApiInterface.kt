package com.darkliself.weatherapp.retrofit_API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers("X-Redmine-API-Key: 6735ebd44e9850ab188356ffba5cbb7cad8aa756")
    @GET("/")
    fun getData(): Call<String>

    @Headers("X-Redmine-API-Key: 6735ebd44e9850ab188356ffba5cbb7cad8aa756")
    @GET("/")
    fun getExpression(): Call<Data>

}