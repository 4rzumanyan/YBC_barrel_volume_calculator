package com.example.ybcaging

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpView()
    }

    private fun setUpView() {
        val enterButton = findViewById<AppCompatTextView>(R.id.enter_button)
        val day = findViewById<AppCompatEditText>(R.id.day)
        val month = findViewById<AppCompatEditText>(R.id.month)
        val year = findViewById<AppCompatEditText>(R.id.year)
        val thisYear = Calendar.getInstance().get(Calendar.YEAR);
        val empty = findViewById<AppCompatTextView>(R.id.empty)
        val notCorrect = findViewById<AppCompatTextView>(R.id.not_correct)
        val under18 = findViewById<AppCompatTextView>(R.id.under18)
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
                startActivity(Intent(this, CalcActivity::class.java))
            else
                under18.visible()
        }
    }
}