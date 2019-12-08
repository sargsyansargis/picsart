package com.example.hwtwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var text1: TextView
    private lateinit var text2: TextView
    private lateinit var text3: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1 = findViewById(R.id.roll1)
        text2 = findViewById(R.id.roll2)
        text3 = findViewById(R.id.roll3)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()
        val randomInt = Random().nextInt(6) + 1

        text3.text = text2.text.toString()
        text2.text = text1.text.toString()
        text1.text = randomInt.toString()

    }
}