package com.faramarz.kotlinapp.mvp

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.faramarz.kotlinapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, ContractMain.View {

    private var presenterMain = PresenterMain()

    override fun getActivity(): Activity {
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenterMain.attachView(this)
        btnGetDataByLatLon.setOnClickListener(this)
        btnGetDataByCityName.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnGetDataByLatLon -> getTempByLatLon()
            R.id.btnGetDataByCityName -> getTempByCityName()
        }
    }


    private fun getTempByLatLon() {
        presenterMain.getTempByLatLon(
            editTextLat.text.toString().trim(),
            editTextLon.text.toString().trim(),
            textTemp
        )
    }

    private fun getTempByCityName() {
        presenterMain.getTempByCityName(editTextCity.text.toString().trim(), textTempCity)
    }

}