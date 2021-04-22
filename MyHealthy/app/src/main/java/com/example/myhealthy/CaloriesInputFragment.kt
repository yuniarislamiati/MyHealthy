package com.example.myhealthy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlin.math.roundToInt


class CaloriesInputFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_calories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.calories_btn)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val EDTX_bb: EditText? = view?.findViewById(R.id.EDTX_bb)
        val EDTX_tg: EditText? = view?.findViewById(R.id.EDTX_tg)
        val EDTX_age: EditText? = view?.findViewById(R.id.EDTX_age)
        if (EDTX_bb?.text?.isNotEmpty() == true && EDTX_tg?.text?.isNotEmpty() == true && EDTX_age?.text?.isNotEmpty() == true) {
            val bbValue = (EDTX_bb.text.toString().toDouble() * 13.4) +88.4
            val tgValue = (EDTX_tg.text.toString().toDouble()) * 4.8
            val ageValue = (EDTX_age.text.toString().toDouble()) * 5.68
            if ( bbValue > 0 ) {
                val result = (bbValue + tgValue - ageValue).roundToInt()

                val caloriesoutputFragment = CaloriesOutputFragment()
                val mFragmentManager = fragmentManager

                caloriesoutputFragment.result = result.toString() + " Kcal"

                mFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fragment, caloriesoutputFragment, CaloriesOutputFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
            } else{
                EDTX_bb.error = "Invalid Input"
                EDTX_tg.error = "Invalid Input"
                EDTX_age.error = "Invalid Input"
            }
        } else{
            when {
                EDTX_bb?.text?.isEmpty() == true -> {
                    EDTX_bb.error = "Field is missing"
                }
                EDTX_tg?.text?.isEmpty () == true -> {
                    EDTX_tg.error = "Field is missing"
                }
                EDTX_age?.text?.isEmpty () == true -> {
                    EDTX_age.error = "Field is missing"
                }
            }
        }

    }
}