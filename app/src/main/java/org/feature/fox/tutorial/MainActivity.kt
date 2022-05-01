package org.feature.fox.tutorial

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val fab: View = findViewById(R.id.fab)
        diceImage = findViewById(R.id.dice_image)

        rollButton.setOnClickListener { rollDice() }
        fab.setOnClickListener { view -> fabSnack(view) }
    }

    private fun rollDice() {
        val drawableResource = when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }

    private fun fabSnack(view: View) {
        Snackbar.make(view, "This FAB needs an action!", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }
}