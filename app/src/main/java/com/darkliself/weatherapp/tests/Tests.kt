package com.darkliself.weatherapp.tests

import java.util.*



fun main(args: Array<String>) {
    val date = DataPickerZZ()
    println(date.getHour())

}


public class DataPickerZZ() {

    private val calendar = Calendar.getInstance()
    private val hour = calendar


    fun getHour(): Int {
        return calendar[Calendar.DATE]
    }
}