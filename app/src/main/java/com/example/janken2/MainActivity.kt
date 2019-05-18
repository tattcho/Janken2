package com.example.janken2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gu.setOnClickListener{onJankenButtonTapped(it)}
        choki.setOnClickListener{onJankenButtonTapped(it)}
        pa.setOnClickListener{onJankenButtonTapped(it)}

        val prefectureManager = null
        val pref = prefectureManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.clear().apply()

    }

    private fun onJankenButtonTapped(view: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

private fun Any.clear(): Any {

}

fun Any.edit(): Any {

}

private fun Nothing?.getDefaultSharedPreferences(mainActivity: MainActivity): Any {

}
