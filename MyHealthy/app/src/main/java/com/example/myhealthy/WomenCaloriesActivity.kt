package com.example.myhealthy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WomenCaloriesActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories_women)

        val inputFragment = WomenInputFragment()
        val mfragment = supportFragmentManager.findFragmentByTag(WomenInputFragment::class.java.simpleName)

        if (mfragment !is WomenInputFragment) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_women, inputFragment, WomenInputFragment::class.java.simpleName)
                    .commit()
        }
    }
}