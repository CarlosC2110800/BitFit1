package com.example.bitfit1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ExerciseActivity : AppCompatActivity() {
    // Variables
    private lateinit var time: EditText
    private lateinit var exerciseDone: EditText
    private lateinit var inputButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        // Set the EditText up to take inputs
        time = findViewById(R.id.etTime)
        exerciseDone = findViewById(R.id.etExerciseName)
        // Set up the button
        inputButton = findViewById(R.id.recordButton)

        inputButton.setOnClickListener {
            if (time.text.isNotEmpty() && exerciseDone.text.isNotEmpty()) {
                val intentExercise = Intent(this, MainActivity::class.java)
                // Send information back!
                intentExercise.putExtra("Exercise!"
                    , ExerciseData(time.text.toString(), exerciseDone.text.toString()))

                this.startActivity(intentExercise)
            }
            else {
                Toast.makeText(this, "Either the time or exercise is empty, input please!"
                , Toast.LENGTH_SHORT).show()
            }
        }



    }
}