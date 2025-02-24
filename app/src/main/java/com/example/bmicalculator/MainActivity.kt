package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets } */

        //Connect activity_main.xml with MainActivity.kt using @id
        //Recover components EditText and Button
        // Create VAR and UI components(EditText)


        val weight = findViewById<TextInputEditText>(R.id.inp_Weight)
        val height = findViewById<TextInputEditText>(R.id.inp_Height)
        val result = findViewById<Button>(R.id.calc)

        // Set Button function
        result.setOnClickListener {
            val edWeight: Float = weight.text.toString().toFloat()
            val edHeight: Float = height.text.toString().toFloat()
            println(edWeight + edHeight)


        }


    }
}