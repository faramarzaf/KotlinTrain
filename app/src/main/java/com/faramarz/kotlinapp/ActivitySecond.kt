package com.faramarz.kotlinapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.faramarz.kotlinapp.weather.*
import kotlinx.android.synthetic.main.activity_second.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class ActivitySecond : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnGetDataByLatLon.setOnClickListener {
            getDataByLatLon()
        }

    }

    fun getDataByLatLon() {

        val request = WeatherRepository.ServiceBuilder.buildService(WeatherAPI::class.java)
        val call = request.getDataByLatLon(
            editTextLat.text.toString(),
            editTextLon.text.toString(),
            API_KEY
        )


        call.enqueue(object : Callback<WeatherResponse> {
            override
            fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Toast.makeText(this@ActivitySecond, t.message, Toast.LENGTH_SHORT).show()
            }

            override
            fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                with(response.body()?.main) {
                    if (response.body() != null) {
                        var tempMain = this!!.temp
                        // Centigrade
                        var tempMainC = tempMain - 273.15
                        val tempC = String.format("%.1f", tempMainC)
                        textTemp.text = "temp is: $tempC $DEGREE_C"
                    } else
                        Toast.makeText(this@ActivitySecond, "Something is wrong", Toast.LENGTH_SHORT)
                }

            }
        })
    }


}

