package com.faramarz.kotlinapp.weather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("data/2.5/weather?")
    fun getDataByLatLon(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") app_id: String
    ):
            Call<WeatherResponse>

}