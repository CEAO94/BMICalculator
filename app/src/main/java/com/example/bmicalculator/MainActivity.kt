package com.example.bmicalculator


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)/* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets } */

// Connect the activity_main.xml layout with MainActivity.kt using @id
// Retrieve the UI components (EditText for input and Button for action)
// Declare variables for UI components (EditText for user input and Button for calculation)
// Set the functionality of the Button
// If the user input is empty, show an error message (e.g., "Please enter valid data")
// If the input is valid, navigate to the second screen
// Create a second screen (activity_bmi_result.xml or similar)
// Transfer calculated BMI value from the MainActivity to the second screen ResultActivity
// Use Intent to start the second screen (activity_bmi_result)
// Use putExtra() to send the BMI value or other necessary data to the second screen

        val weight = findViewById<TextInputEditText>(R.id.inp_Weight)
        val height = findViewById<TextInputEditText>(R.id.inp_Height)
        val result = findViewById<Button>(R.id.calc)

        result.setOnClickListener {
            val typeWeight: String = weight.text.toString()
            val typeHeight: String = height.text.toString()


            if (typeWeight == "" || typeHeight == "") {
                Snackbar.make(weight, "You must enter a valid value.", Snackbar.LENGTH_LONG).show()
            } else {
                val tWeight: Float = typeWeight.toFloat() //short code line
                val tHeight: Float = typeHeight.toString().toFloat() //long code line

                val heightBMI: Float = tHeight * tHeight
                val result = tWeight / heightBMI

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_BMI, result)
                startActivity(intent)
                println(result)

            }
        }
    }
}