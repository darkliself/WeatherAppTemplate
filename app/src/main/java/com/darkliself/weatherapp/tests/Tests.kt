package com.darkliself.weatherapp.tests

import java.util.*



fun main(args: Array<String>) {
    val date = DataPickerZZ()
    println(date.getDate())

}


public class DataPickerZZ() {

    private val calendar = Calendar.getInstance()
    private val hour = calendar


    fun getDate(): Int {
        return calendar[Calendar.DATE]
    }
}


class APICall() {


    // http://api.openweathermap.org/geo/1.0/direct?q=London&limit=5&appid={API key}
    fun findCity() {

    }
}