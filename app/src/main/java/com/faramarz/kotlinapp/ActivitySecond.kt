package com.faramarz.kotlinapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.faramarz.kotlinapp.weather.DEGREE_C
import com.faramarz.kotlinapp.weather.OnGetTempCallback
import com.faramarz.kotlinapp.weather.WeatherRepository
import com.faramarz.kotlinapp.weather.WeatherResponse
import kotlinx.android.synthetic.main.activity_second.*
import retrofit2.Response


class ActivitySecond : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        btnGetDataByLatLon.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnGetDataByLatLon -> getTemp()
        }
    }

    fun getTemp() {
        WeatherRepository.GetDateByLatLon.getData(editTextLat.text.toString().trim(),
            editTextLon.text.toString().trim(), object : OnGetTempCallback {
                override fun onSuccess(weather: Response<WeatherResponse>?) {
                    with(weather?.body()?.main) {
                        if (weather?.body() != null) {
                            var tempMain = this!!.temp //kalvin

                            var TempC = ConversionUtil.KToC.convert(tempMain)
                            val tempC = String.format("%.1f", TempC)
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

