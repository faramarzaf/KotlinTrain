package com.faramarz.kotlinapp.mvp

import android.app.Activity
import android.widget.TextView

class PresenterMain : ContractMain.Presenter {


    private var view: ContractMain.View? = null
    private var model = ModelMain()

    override fun attachView(view: ContractMain.View) {
        this.view = view
        model.attachPresenter(this)
    }

    override fun getActivity(): Activity {
        return view!!.getActivity()
    }

    override fun getTempByLatLon(lat: String, lon: String, textView: TextView) {
        model.getTempByLatLon(lat, lon, textView)
    }

    override fun getTempByCityName(cityName: String, textView: TextView) {
        model.getTempByCityName(cityName, textView)
    }


}