package com.faramarz.kotlinapp.mvp

import android.widget.TextView
import android.widget.Toast
import com.faramarz.kotlinapp.interfaces.OnGetTempCallback
import com.faramarz.kotlinapp.network.WeatherRepository
import com.faramarz.kotlinapp.network.WeatherResponse
import com.faramarz.kotlinapp.utils.DEGREE_C
import com.faramarz.kotlinapp.utils.TempConversion
import retrofit2.Response

class ModelMain : ContractMain.Model {

    private var presenter: ContractMain.Presenter? = null

    override fun attachPresenter(presenter: ContractMain.Presenter) {
        this.presenter = presenter
    }

    override fun getTempByLatLon(lat: String, lon: String, textView: TextView) {
        WeatherRepository.GetDateByLatLon.getData(lat, lon, object : OnGetTempCallback {
            override fun onSuccess(weather: Response<WeatherResponse>?) {
                with(weather?.body()?.main) {
                    if (weather?.body() != null) {
                        val tempMain = this!!.temp //kalvin
                        val TempC = TempConversion.KToC.convert(tempMain)
                        val tempC = String.format("%.1f", TempC)
                        textView.text = "temp is: $tempC $DEGREE_C"
                    }
                }
            }

            override fun onError(msg: String?) {
                Toast.makeText(presenter?.getActivity(), msg, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun getTempByCityName(cityName: String, textView: TextView) {
        WeatherRepository.GetDataByCityName.getData(cityName, object : OnGetTempCallback {
            override fun onSuccess(weather: Response<WeatherResponse>?) {
                with(weather?.body()?.main) {
                    if (weather?.body() != null) {
                        val tempMain = this!!.temp
                        val TempC = TempConversion.KToC.convert(tempMain)
                        val tempC = String.format("%.1f", TempC)
                        textView.text = "temp is: $tempC $DEGREE_C"
                    }
                }
            }

            override fun onError(msg: String?) {
                Toast.makeText(presenter?.getActivity(), msg, Toast.LENGTH_SHORT).show()
            }
        })
    }

}