package com.main.SIPHI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class AnalysisActivity : AppCompatActivity() {

    var displayText: String? = "Hello, How are you. Hope you are practising your vocal skills"

    lateinit var txtDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analysis)

        txtDisplay = findViewById(R.id.txtDisplay)

        if (intent != null) {
            displayText = intent.getStringExtra("Display")
        }
        txtDisplay.text = displayText

        title = "Analysis Window"
    }
}