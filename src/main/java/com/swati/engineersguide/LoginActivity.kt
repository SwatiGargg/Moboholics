package com.swati.engineersguide


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.String as String1


class LoginActivity : AppCompatActivity() {


    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var FogotPassword: TextView
    lateinit var SignUP: TextView
    val validMobileNumber = "9992345222"
    val validPassword = arrayOf("realme", "redmi", "Poco", "Smartphone")
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file), Context.MODE_PRIVATE)
        val isLoggedIn: Boolean = sharedPreferences.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_login)
        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        title = "Log In"
        etMobileNumber = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPass)
        btnLogin = findViewById(R.id.btnLog)
        FogotPassword = findViewById(R.id.ForgotPass)
        SignUP = findViewById(R.id.SignUP)


        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameOfMobile: String1
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            if (mobileNumber == validMobileNumber) {
                if (password == validPassword[0]) {
                    nameOfMobile = "REALME"
                    savedPreferences(nameOfMobile)
                    startActivity(intent)
                } else if (password == validPassword[1]) {
                    nameOfMobile = "REDMI"
                    savedPreferences(nameOfMobile)
                    startActivity(intent)
                } else if (password == validPassword[2]) {
                    nameOfMobile = "POCO"
                    savedPreferences(nameOfMobile)
                    startActivity(intent)

                } else if (password == validPassword[3]) {
                    nameOfMobile = "SMART PHONES"
                    savedPreferences(nameOfMobile)
                    startActivity(intent)
                } else {

                    Toast.makeText(this@LoginActivity, "Enter correct credentials", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }


    override fun onPause() {
        super.onPause()
        finish()
    }

     fun savedPreferences(title: kotlin.String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
         sharedPreferences.edit().putString("Title", title ).apply()
    }
}
