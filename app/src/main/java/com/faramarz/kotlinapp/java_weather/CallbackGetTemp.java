package com.faramarz.kotlinapp.java_weather;

import com.faramarz.kotlinapp.java_weather.model.WeatherModel;

public interface CallbackGetTemp {

    void onSuccess(WeatherModel weather);

    void onError();

}
