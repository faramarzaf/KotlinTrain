package com.faramarz.kotlinapp.java_weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.faramarz.kotlinapp.R;
import com.faramarz.kotlinapp.java_weather.model.WeatherModel;

public class ActivityJava extends AppCompatActivity {

    TextView textJavaWeather;
    BackendRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        textJavaWeather = findViewById(R.id.textJavaWeather);
        repository = BackendRepository.getInstance();
        getData();
    }

    void getData() {
        repository.getWeatherTemp(new CallbackGetTemp() {
            @Override
            public void onSuccess(WeatherModel weather) {
                textJavaWeather.setText(String.valueOf(weather.getMain().getTempMax()));
            }

            @Override
            public void onError() {
                Toast.makeText(ActivityJava.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
