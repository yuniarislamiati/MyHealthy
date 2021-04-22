package com.example.myhealthy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardBMI: CardView = findViewById(R.id.card_bmi)
        cardBMI.setOnClickListener(this)

        val cardList: CardView = findViewById(R.id.card_list)
        cardList.setOnClickListener(this)

        val cardFragment: CardView = findViewById(R.id.card_fragment)
        cardFragment.setOnClickListener(this)

        val cardAbout: CardView = findViewById(R.id.card_about)
        cardAbout.setOnClickListener(this)

        val cardCalories: CardView = findViewById(R.id.card_calories)
        cardCalories.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.card_bmi -> {
                val moveIntent = Intent(this@MainActivity, BMIActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.card_list -> {
                val moveIntent = Intent(this@MainActivity, ListFoodActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.card_fragment -> {
                val moveIntent = Intent(this@MainActivity, WomenCaloriesActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.card_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.card_calories -> {
                val moveIntent = Intent(this@MainActivity, CaloriesActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}