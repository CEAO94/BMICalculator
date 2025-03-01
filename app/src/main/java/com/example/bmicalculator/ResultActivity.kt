package com.example.bmicalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_BMI = "ResultActivity.KEY_BMI"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val actResult = intent.getFloatExtra(KEY_RESULT_BMI, 0f)

        val numbResult = findViewById<TextView>(R.id.view_numbResult)
        numbResult.text = actResult.toString()

        val textResult = findViewById<TextView>(R.id.view_textResult)

        val range: String = if (actResult <= 18.5f) {
            "Underweight"
        } else if (actResult > 18.5f && actResult <= 24.99f) {
            "Normal"
        } else if (actResult > 24.99f && actResult <= 29.99f) {
            "Overweight"
        } else if (actResult > 29.99f && actResult <= 34.99f) {
            "Obesity Class I"
        } else if (actResult > 34.99 && actResult <= 39.99) {
            "Obesity Class II"
        } else {
            "Obesity Class III"
        }

        textResult.text = range
    }
}