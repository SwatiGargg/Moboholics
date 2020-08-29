package com.swati.engineersguide

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var titleName:String? = "MOBOHOLICS"
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preferences_file), Context.MODE_PRIVATE)
        setContentView(R.layout.listofmobiles_activity)
       titleName=sharedPreferences.getString("title","SMART PHONES")
        title = titleName

    }
}
