package com.faramarz.kotlinapp.java_weather;

import com.faramarz.kotlinapp.java_weather.model.WeatherModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.faramarz.kotlinapp.weather.ConstantsKt.API_KEY;

public class BackendRepository {


    private static BackendRepository repository;
    private JavaAPIInterface api;

    private BackendRepository(JavaAPIInterface api) {
        this.api = api;
    }


    public static BackendRepository getInstance() {
        if (repository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            repository = new BackendRepository(retrofit.create(JavaAPIInterface.class));
        }
        return repository;
    }

    public void getWeatherTemp(final CallbackGetTemp callback) {
        Callback<WeatherModel> call = new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (response.isSuccessful()) {
                    WeatherModel weatherModel = response.body();
                    if (weatherModel != null) {
                        callback.onSuccess(weatherModel);
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                callback.onError();
            }
        };
        api.getTemp(API_KEY, "24", "23").enqueue(call);
    }

}
