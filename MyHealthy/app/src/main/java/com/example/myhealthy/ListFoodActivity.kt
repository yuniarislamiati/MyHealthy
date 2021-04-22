package com.example.myhealthy

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class ListFoodActivity : AppCompatActivity() {

    lateinit var adapter: FoodAdapter
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataName: Array<String>
    private lateinit var dataCalories: Array<String>
    private lateinit var dataVitamin: Array<String>
    private lateinit var foods: ArrayList<FoodData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_food)

        prepare()

        adapter = FoodAdapter(this, addItem())
        val lv_list : ListView = findViewById(R.id.lv_list)
        lv_list.adapter = adapter

    }

    private fun prepare() {
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataName = resources.getStringArray(R.array.name)
        dataCalories = resources.getStringArray(R.array.calories)
        dataVitamin = resources.getStringArray(R.array.vitamin)
    }

    private fun addItem() : ArrayList<FoodData> {
        foods = ArrayList()
        for (i in dataName.indices) {
            val food = FoodData()
            food.avatar = dataAvatar.getResourceId(i, -1)
            food.name = dataName[i]
            food.calories = dataCalories[i]
            food.vitamin = dataVitamin[i]
            foods.add(food)
        }
        return foods
    }
}


