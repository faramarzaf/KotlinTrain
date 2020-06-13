package com.faramarz.kotlinapp.weather

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {

    object ServiceBuilder {
        private val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        fun <T> buildService(service: Class<T>): T {
            return retrofit.create(service)
        }
    }

    /*object ABC {
        val client = OkHttpClient.Builder().build()
        val retrofits = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        fun <T> sum(service: Class<T>): T {
            return retrofits.create(service)
        }
        fun getTemp(callback: OnGetTempCallback) {
            //  val cal = weatherAPI?.getDataByLatLon("45", "45,", API_KEY)
            val request = ABC.sum(WeatherAPI::class.java)
            val call = request.getDataByLatLon("45", "45,", API_KEY)

            call.enqueue(object : Callback<WeatherResponse> {
                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    callback.onError()
                }

                override fun onResponse(
                    call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                    if (response.isSuccessful) {
                        val weatherResponse: WeatherResponse = response.body()!!
                        if (weatherResponse != null) {
                            callback.onSuccess(weatherResponse)
                        } else
                            callback.onError()
                    } else
                        callback.onError()
                }
            })
        }
    }*/

}