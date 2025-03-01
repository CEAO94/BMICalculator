package com.example.bmicalculator


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
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
        var result = findViewById<Button>(R.id.calc)

        // Set Button function
        result.setOnClickListener {
            val typeWeight: String = weight.text.toString()
            val typeHeight: String = height.text.toString()


            if (typeWeight == "" || typeHeight == "")
            //Empty - show a error message to the user
            {
                Snackbar.make(weight, "You must enter a valid value.", Snackbar.LENGTH_LONG).show()

            } else {
                val tWeight: Float = typeWeight.toFloat() //short code line
                val tHeight: Float = typeHeight.toString().toFloat() //long code line

                val heightBMI: Float = tHeight * tHeight
                val button = tWeight / heightBMI
                println(button)

                //Navegate to second screen;
                //Create the second screen
                //Transfer information between screens

                // Intent - Android Class


                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)


            }


        }


    }
}