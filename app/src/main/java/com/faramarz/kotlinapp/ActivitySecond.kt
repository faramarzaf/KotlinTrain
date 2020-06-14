package com.faramarz.kotlinapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.faramarz.kotlinapp.weather.DEGREE_C
import com.faramarz.kotlinapp.weather.OnGetTempCallback
import com.faramarz.kotlinapp.weather.WeatherRepository
import com.faramarz.kotlinapp.weather.WeatherResponse
import kotlinx.android.synthetic.main.activity_second.*
import retrofit2.Response


class ActivitySecond : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnGetDataByLatLon.setOnClickListener {
            WeatherRepository.GetDateByLatLon.getData(editTextLat.text.toString(),
                editTextLon.text.toString(), object : OnGetTempCallback {
                    override fun onSuccess(weather: Response<WeatherResponse>?) {
                        with(weather?.body()?.main) {
                            if (weather?.body() != null) {
                                var tempMain = this!!.temp //kalvin
                                // Centigrade conversion
                                var tempMainC = tempMain - 273.15
                                val tempC = String.format("%.1f", tempMainC)
                                textTemp.text = "temp is: $tempC $DEGREE_C"
                            }
                        }
                    }

                    override fun onError(msg: String?) {
                        Toast.makeText(this@ActivitySecond, msg, Toast.LENGTH_SHORT).show()
                    }
                })
        }

    }


}

