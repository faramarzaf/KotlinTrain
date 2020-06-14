package com.faramarz.kotlinapp.network

import com.faramarz.kotlinapp.utils.API_KEY
import com.faramarz.kotlinapp.utils.BASE_URL
import com.faramarz.kotlinapp.interfaces.OnGetTempCallback
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {

    object ServiceBuilder {
        private val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        fun <T> buildService(service: Class<T>): T {
            return retrofit.create(service)
        }
    }

    object GetDateByLatLon {
        fun getData(lat: String, lon: String, callback: OnGetTempCallback) {
            val request =
                ServiceBuilder.buildService(WeatherAPI::class.java)
            val call = request.getDataByLatLon(lat, lon, API_KEY)

            call.enqueue(object : Callback<WeatherResponse> {
                override
                fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    callback.onError(t.message)
                }

                override
                fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                    if (response.body() != null)
                        callback.onSuccess(response)
                }
            })
        }
    }

    object GetDataByCityName {
        fun getData(cityName: String, callback: OnGetTempCallback) {
            val request =
                ServiceBuilder.buildService(WeatherAPI::class.java)
            val call = request.getDataByCityName(cityName, API_KEY)
            call.enqueue(object : Callback<WeatherResponse> {
                override
                fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    callback.onError(t.message)
                }

                override
                fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                    if (response.body() != null)
                        callback.onSuccess(response)
                }
            })

        }
    }
}