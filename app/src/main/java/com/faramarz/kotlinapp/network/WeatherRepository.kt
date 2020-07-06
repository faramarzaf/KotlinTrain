package com.faramarz.kotlinapp.network

import com.faramarz.kotlinapp.interfaces.OnGetTempCallback
import com.faramarz.kotlinapp.network.WeatherRepository.ServiceBuilder.myRequest
import com.faramarz.kotlinapp.utils.API_KEY
import com.faramarz.kotlinapp.utils.BASE_URL
import com.faramarzaf.sdk.af_android_sdk.core.network.ServiceRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {

    object ServiceBuilder {
        val myRequest =
            ServiceRepository.ServiceBuilder.buildService(BASE_URL, WeatherAPI::class.java)
    }

    object getDateByLatLon {
        fun getData(lat: String, lon: String, callback: OnGetTempCallback) {
            val call = myRequest.getDataByLatLon(lat, lon, API_KEY)
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

    object getDataByCityName {
        fun getData(cityName: String, callback: OnGetTempCallback) {
            val call = myRequest.getDataByCityName(cityName, API_KEY)
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