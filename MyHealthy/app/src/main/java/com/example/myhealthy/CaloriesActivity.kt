package com.example.myhealthy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CaloriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories)

        val inputcaloriesFragment = CaloriesInputFragment()
        val fragment = supportFragmentManager.findFragmentByTag(CaloriesInputFragment::class.java.simpleName)

        if (fragment !is CaloriesInputFragment) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment, inputcaloriesFragment, CaloriesInputFragment::class.java.simpleName)
                .commit()
        }
    }
}