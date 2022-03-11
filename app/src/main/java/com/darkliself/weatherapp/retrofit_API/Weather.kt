package com.darkliself.weatherapp.retrofit_API

import android.accounts.AuthenticatorDescription
import com.google.gson.annotations.SerializedName


data class Weather(
    val main: String,
    val description: String,
)