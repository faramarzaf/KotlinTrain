package com.faramarz.kotlinapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private val name = "fara"
    private val age = 22
    private val myText = "hi im $name and im ${age.toString()} years old"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener(this)
        btnNextPage.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSave -> textView.text = editText.text
            R.id.btnNextPage -> startActivity(Intent(this, ActivitySecond::class.java))
        }
    }
}
