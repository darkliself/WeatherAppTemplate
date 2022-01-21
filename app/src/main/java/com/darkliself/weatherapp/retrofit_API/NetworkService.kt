package com.darkliself.weatherapp.retrofit_API

import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


fun main() {
    // NetworkService.getMyData()
    // NetworkService.getData("552139")
    NetworkService.getExpression("552139/")

}


object NetworkService {
    private val BaseURL = "https://cnet.plan.io/issues/"

    fun getExpression(endPoint: String) {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("$BaseURL$endPoint/")
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getExpression()
        retrofitData.enqueue(object : Callback<Data?> {
            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {

                if (response.isSuccessful) {
                    println(response.body())
                }
            }

            override fun onFailure(call: Call<Data?>, t: Throwable) {
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