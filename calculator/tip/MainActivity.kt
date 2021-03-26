package com.example.new_avd

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.hyperskill.calculator.tip.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int,
                                       before: Int, count: Int) {
                displayTipAmount()
            }
        })

        slider.addOnChangeListener { slider, value, fromUser -> displayTipAmount() }
    }

    fun displayTipAmount() {
        if (edit_text.length() == 0 || edit_text.equals("")) {
            text_view.visibility = View.GONE
        } else {
            text_view.visibility = View.VISIBLE
            val billValue = edit_text.text.toString().toDouble()
            val tipPercentage = slider.value.toInt()
            var result:Double = (billValue * tipPercentage)/100.00
            var filterUserPrice: String? = "%.2f".format(result)
            text_view.text = "Tip amount: $filterUserPrice"
        }
    }
}
