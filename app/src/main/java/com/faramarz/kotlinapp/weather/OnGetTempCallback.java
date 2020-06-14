package com.faramarz.kotlinapp.weather;

import retrofit2.Response;

public interface OnGetTempCallback {

    void onSuccess(Response<WeatherResponse> weather);

    void onError(String msg);

}
