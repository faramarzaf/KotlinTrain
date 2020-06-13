package com.faramarz.kotlinapp.weather;

public interface OnGetTempCallback {

    void onSuccess(WeatherResponse weather);

    void onError();

}
