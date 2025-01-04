package com.main.SIPHI

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNum: EditText
    lateinit var etPassword: EditText
    lateinit var btnLog: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber = "1234567890"
    val validPassword = arrayOf("anuj", "het", "vaibhav", "valay")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_login)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        title = "Log In"

        etMobileNum = findViewById(R.id.etMobileNum)
        etPassword = findViewById(R.id.etPassword)
        btnLog = findViewById(R.id.btnLog)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        btnLog.setOnClickListener {

            val mobileNumber = etMobileNum.text.toString()

            val password = etPassword.text.toString()

            var nameOfUser = "Anuj"

            val intent = Intent(this@LoginActivity, MainActivity::class.java)

            if ((mobileNumber == validMobileNumber)) {

                when (password) {
                    validPassword[0] -> {

                        nameOfUser = "Anuj Singh"

                        savePreferences(nameOfUser)

                        startActivity(intent)

                    }
                    validPassword[1] -> {

                        nameOfUser = "Het Dave"

                        savePreferences(nameOfUser)

                        startActivity(intent)
                    }
                    validPassword[2] -> {

                        nameOfUser = "Vaibhav Nohwar"

                        savePreferences(nameOfUser)

                        startActivity(intent)
                    }
                    validPassword[3] -> {

                        nameOfUser = "Valay Saitwadekar"

                        savePreferences(nameOfUser)

                        startActivity(intent)
                    }
                    else -> Toast.makeText(
                        this@LoginActivity,
                        "Incorrect Password",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(this@LoginActivity, "Invalid Credentials", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }


    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }
}