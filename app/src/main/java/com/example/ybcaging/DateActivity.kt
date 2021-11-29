package com.example.ybcaging

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.util.*

class DateActivity : Fragment(R.layout.activity_date) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }

    private fun setupView(view: View) {
        val enterButton = view.findViewById<AppCompatTextView>(R.id.enter_button)
        val day = view.findViewById<AppCompatEditText>(R.id.day)
        val month = view.findViewById<AppCompatEditText>(R.id.month)
        val year = view.findViewById<AppCompatEditText>(R.id.year)
        val thisYear = Calendar.getInstance().get(Calendar.YEAR)
        val empty = view.findViewById<AppCompatTextView>(R.id.empty)
        val notCorrect = view.findViewById<AppCompatTextView>(R.id.not_correct)
        val under18 = view.findViewById<AppCompatTextView>(R.id.under18)
        enterButton.setOnClickListener {
            empty.invisible()
            under18.invisible()
            notCorrect.invisible()
            if (day.text.toString() == "" || month.text.toString() == "" || year.text.toString() == "")
                empty.visible()
            else if (!(1 <= (day.text.toString().toInt()) && (day.text.toString()
                    .toInt()) <= 31) ||
                !(1 <= (month.text.toString().toInt()) && (month.text.toString()
                    .toInt()) <= 12) ||
                !(1900 <= (year.text.toString().toInt()) && (year.text.toString()
                    .toInt()) <= thisYear)
            )
                notCorrect.visible()
            else if (thisYear - (year.text.toString().toInt()) >= 18)
                findNavController().navigate(R.id.action_dateActivity_to_calcActivity)
            else
                under18.visible()
        }
    }
}

