package com.example.ybcaging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class CalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        setUpView()
    }

    private fun setUpView() {
        val calcButton = findViewById<AppCompatTextView>(R.id.calc_button)
        val height = findViewById<AppCompatEditText>(R.id.height)
        val topRadius = findViewById<AppCompatEditText>(R.id.top_radius)
        val midRadius = findViewById<AppCompatEditText>(R.id.mid_radius)
        val empty1 = findViewById<AppCompatTextView>(R.id.empty1)
        val greater0 = findViewById<AppCompatTextView>(R.id.greater0)
        val result = findViewById<AppCompatTextView>(R.id.result)
        calcButton.setOnClickListener {
            empty1.invisible()
            greater0.invisible()
            result.invisible()
            if (height.text.toString() == "" || topRadius.text.toString() == "" || midRadius.text.toString() == "")
                empty1.visible()
            else if (height.text.toString().toInt() <= 0 || topRadius.text.toString()
                    .toInt() <= 0 || midRadius.text.toString().toInt() <= 0
            )
                greater0.visible()
            else
                result.text = getString(
                    R.string.volume,
                    barrelVolume(
                        height.text.toString().toInt(),
                        topRadius.text.toString().toInt(),
                        midRadius.text.toString().toInt()
                    )
                )
            result.visible()
        }
    }

    private fun barrelVolume(height: Int, topRadius: Int, midRadius: Int) =
        Math.PI * height * (2 * topRadius * topRadius + midRadius * midRadius) / 12000000
}