package com.example.myhealthy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
//import com.google.android.material.snackbar.Snackbar

import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        actionBar?.setIcon(R.drawable.bmi_logo)

        val Btncalculate: Button = findViewById(R.id.calculateBtn)
        Btncalculate.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.calculateBtn -> {
                val weightEDTX: EditText = findViewById(R.id.weightEDTX)
                val heightEDTX: EditText = findViewById(R.id.heightEDTX)
                if (heightEDTX.text.isNotEmpty() && weightEDTX.text.isNotEmpty()){
                    val weight = weightEDTX.text.toString().toDouble()
                    val height = heightEDTX.text.toString().toDouble()/100
                    if (weight > 0 && weight < 600 && height >= 0.50 && height < 2.50) {
                        val intent = Intent(this@BMIActivity, ResultActivity::class.java)
                        intent.putExtra("bmi", calculateBMI(weight, height))
                        startActivity(intent)
                    }
                } else {
                    when {
                        weightEDTX.text.isEmpty() -> {
                            weightEDTX.error = "Field is missing"
                        }
                        heightEDTX.text.isEmpty () -> {
                            heightEDTX.error = "Field is missing"
                        }
                    }
                }
            }
        }
    }

    private fun calculateBMI(weight: Double, height: Double) = BigDecimal(weight / (height * height))
        .setScale(2, RoundingMode.HALF_EVEN).toDouble()

}
