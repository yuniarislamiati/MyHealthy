package com.example.myhealthy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlin.math.roundToInt


class WomenInputFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_women, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonSend: Button = view.findViewById(R.id.send_btn)
        buttonSend.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val EDTX_bb_women: EditText? = view?.findViewById(R.id.EDTX_bb_women)
        val EDTX_tg_women: EditText? = view?.findViewById(R.id.EDTX_tg_women)
        val EDTX_age_women: EditText? = view?.findViewById(R.id.EDTX_age_women)
        if (EDTX_bb_women?.text?.isNotEmpty() == true && EDTX_tg_women?.text?.isNotEmpty() == true && EDTX_age_women?.text?.isNotEmpty() == true) {
            val bbValue_women = (EDTX_bb_women.text.toString().toDouble() * 9.25) + 447.6
            val tgValue_women = (EDTX_tg_women.text.toString().toDouble()) * 3.10
            val ageValue_women = (EDTX_age_women.text.toString().toDouble()) * 4.33
            if ( bbValue_women > 0 ) {
                val resultwomen = (bbValue_women + tgValue_women - ageValue_women).roundToInt()

                val outputFragment = WomenOutputFragment()
                val nFragmentManager = fragmentManager

                outputFragment.resultwomen = resultwomen.toString() + " Kcal"

                nFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.fragment_women, outputFragment, WomenOutputFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
            } else{
                EDTX_bb_women.error = "Invalid Input"
                EDTX_tg_women.error = "Invalid Input"
                EDTX_age_women.error = "Invalid Input"
            }
        } else{
            when {
                EDTX_bb_women?.text?.isEmpty() == true -> {
                    EDTX_bb_women.error = "Field is missing"
                }
                EDTX_tg_women?.text?.isEmpty () == true -> {
                    EDTX_tg_women.error = "Field is missing"
                }
                EDTX_age_women?.text?.isEmpty () == true -> {
                    EDTX_age_women.error = "Field is missing"
                }
            }
        }

    }


}