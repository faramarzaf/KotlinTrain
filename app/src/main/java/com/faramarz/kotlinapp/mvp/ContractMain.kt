package com.faramarz.kotlinapp.mvp

import android.app.Activity
import android.widget.TextView

interface ContractMain {

    interface View {
        fun getActivity(): Activity
    }

    interface Presenter {
        fun attachView(view: View)
        fun getActivity(): Activity
        fun getTempByLatLon(lat: String, lon: String, textView: TextView)
        fun getTempByCityName(cityName: String, textView: TextView)
    }

    interface Model {
        fun attachPresenter(presenter: Presenter)
        fun getTempByLatLon(lat: String, lon: String, textView: TextView)
        fun getTempByCityName(cityName: String, textView: TextView)
    }
}