package com.example.hwthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var uOneMax = 0
    private var uTwoMax = 0
    private var edgePoint = 2
    private var uOneEdgePoint = 0
    private var uTwoEdgePoint = 0
    private lateinit var diceImage: ImageView
    private lateinit var diceImage2: ImageView
    private lateinit var diceImage3: ImageView
    private lateinit var diceImage4: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton1: Button = findViewById(R.id.roll_button1)
        rollButton1.setOnClickListener { uOneRollDice() }
        val rollButton2: Button = findViewById(R.id.roll_button2)
        rollButton2.setOnClickListener { uTwoRollDice() }


        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)
        diceImage3 = findViewById(R.id.dice_image3)
        diceImage4 = findViewById(R.id.dice_image4)

    }

    private fun uOneRollDice() {

        val one = getRandomDiceImage()
        val two = getRandomDiceImage()

        if (uOneEdgePoint < edgePoint) {

            diceImage.setImageResource(one.first)
            diceImage2.setImageResource(two.first)

            if (one.second + two.second > uOneMax)
                uOneMax = one.second + two.second
            uOneEdgePoint++
        } else {
            Toast.makeText(
                this, "user two turn",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun uTwoRollDice() {
        if (uOneEdgePoint != 2) {
            Toast.makeText(
                this, "user one turn",
                Toast.LENGTH_SHORT
            ).show()

            return
        }

        if (uTwoEdgePoint < edgePoint) {
            val one = getRandomDiceImage()
            val two = getRandomDiceImage()

            diceImage3.setImageResource(one.first)
            diceImage4.setImageResource(two.first)

            if (one.second + two.second > uTwoMax)
                uTwoMax = one.second + two.second
            uTwoEdgePoint++
        } else
            getWinner()
    }


    private fun getWinner() {
        when {
            (uOneMax - uTwoMax) > 0 -> Toast.makeText(
                this, "user one win",
                Toast.LENGTH_SHORT
            ).show()
            (uOneMax - uTwoMax) < 0 -> Toast.makeText(
                this, "user two win",
                Toast.LENGTH_SHORT
            ).show()
            else -> Toast.makeText(
                this, "no winner",
                Toast.LENGTH_SHORT
            ).show()
        }
        val intent = intent
        finish()
        startActivity(intent)
    }

    private fun getRandomDiceImage() =

        when (Random().nextInt(6) + 1) {
            1 -> Pair(R.drawable.dice_1, 1)
            2 -> Pair(R.drawable.dice_2, 2)
            3 -> Pair(R.drawable.dice_3, 3)
            4 -> Pair(R.drawable.dice_4, 4)
            5 -> Pair(R.drawable.dice_5, 5)
            else -> Pair(R.drawable.dice_6, 6)
        }


}

