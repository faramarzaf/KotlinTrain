package com.faramarz.kotlinapp.interfaces;

import com.faramarz.kotlinapp.network.WeatherResponse;

import retrofit2.Response;

public interface OnGetTempCallback {

    void onSuccess(Response<WeatherResponse> weather);

    void onError(String msg);

}
