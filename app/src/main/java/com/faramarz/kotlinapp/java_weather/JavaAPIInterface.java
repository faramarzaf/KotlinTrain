package com.faramarz.kotlinapp.java_weather;

import com.faramarz.kotlinapp.java_weather.model.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JavaAPIInterface {

    @GET("data/2.5/weather?")
    Call<WeatherModel> getTemp(
            @Query("appid") String apiKey,
            @Query("lat") String lat,
            @Query("lon") String lon
    );

}
