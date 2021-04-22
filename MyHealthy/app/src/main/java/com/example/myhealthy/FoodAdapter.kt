package com.example.myhealthy

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class FoodAdapter (private val context: Context, private val listFood : ArrayList<FoodData>) : BaseAdapter() {
    @SuppressLint("InflateParams")
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.food_item, null, true)
        }
        val viewHolder = ViewHolder(itemView as View)
        val food = getItem(position) as FoodData
        viewHolder.bind(food)
        return itemView
    }

    override fun getItem(i: Int): Any {
        return listFood[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return listFood.size
    }

    private inner class ViewHolder(view: View) {
        private val imgAvatar: CircleImageView = view.findViewById(R.id.img_avatar)
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtCalories: TextView = view.findViewById(R.id.txt_calories)
        private val txtVitamin: TextView = view.findViewById(R.id.txt_vitamin)

        fun bind(food: FoodData) {
            food.avatar?.let { imgAvatar.setImageResource(it) }
            txtName.text = food.name
            txtCalories.text = food.calories
            txtVitamin.text = food.vitamin
        }
    }
}