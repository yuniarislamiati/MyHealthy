package com.example.myhealthy

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class ResultActivity : AppCompatActivity(){
    @SuppressLint("WrongViewCast", "SetTextI18n", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_result)

        val containerL : LinearLayout = findViewById(R.id.containerL)
        val bmiValueTV : TextView = findViewById(R.id.bmiValueTV)
        val bmiFlagImgView : ImageView = findViewById(R.id.bmiFlagImgView)
        val bmiLabelTV : TextView = findViewById(R.id.bmiLabelTV)
        val commentTV : TextView = findViewById(R.id.commentTV)
        val advice1IMG : ImageView = findViewById(R.id.advice1IMG)
        val advice1TV : TextView = findViewById(R.id.advice1TV)
        val advice2IMG : ImageView = findViewById(R.id.advice2IMG)
        val advice2TV : TextView = findViewById(R.id.advice2TV)
        val advice3IMG : ImageView = findViewById(R.id.advice3IMG)
        val advice3TV : TextView = findViewById(R.id.advice3TV)

        val bmi = intent.getDoubleExtra("bmi", -1.0)
        if (bmi == -1.0) {
            containerL.visibility= View.GONE
        }else {
            bmiValueTV.text = bmi.toString()
            if (bmi < 18.5) {
//                containerL.setBackgroundResource(R.color.Kuning)
                bmiFlagImgView.setImageResource(R.drawable.silang)
                bmiLabelTV.text = "You have an UnderWeight!"
                commentTV.text = "Here are some advices To help you increase your weight"
                advice1IMG.setImageResource(R.drawable.nowater)
                advice1TV.text = "Don't drink water before meals"
                advice2IMG.setImageResource(R.drawable.bigmeal)
                advice2TV.text = "Use bigger plates"
                advice3TV.text = "Get quality sleep"
            }else {
                if (bmi > 25) {
//                    containerL.setBackgroundResource(R.color.Red)
                    bmiFlagImgView.setImageResource(R.drawable.warning)
                    bmiLabelTV.text="You have an OverWeight!"
                    commentTV.text="Here are some advices To help you decrease your weight"
                    advice1IMG.setImageResource(R.drawable.water)
                    advice1TV.text="Drink water a half hour before meals"
                    advice2IMG.setImageResource(R.drawable.twoeggs)
                    advice2TV.text="Eeat only two meals per day and make sure that they contains a high protein"
                    advice3IMG.setImageResource(R.drawable.nosugar)
                    advice3TV.text="Drink coffee or tea and Avoid sugary food"
                }
            }
        }
    }
}