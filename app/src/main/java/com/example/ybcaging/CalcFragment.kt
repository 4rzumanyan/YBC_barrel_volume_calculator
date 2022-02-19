package com.example.ybcaging

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class CalcFragment : Fragment(R.layout.activity_calc) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }

    private fun setupView(view: View) {
        val backButton = view.findViewById<AppCompatImageView>(R.id.back_button)
        val calcButton = view.findViewById<AppCompatTextView>(R.id.calc_button)
        val height = view.findViewById<AppCompatEditText>(R.id.height)
        val topRadius = view.findViewById<AppCompatEditText>(R.id.top_radius)
        val midRadius = view.findViewById<AppCompatEditText>(R.id.mid_radius)
        val empty1 = view.findViewById<AppCompatTextView>(R.id.empty1)
        val greater0 = view.findViewById<AppCompatTextView>(R.id.greater0)
        val result = view.findViewById<AppCompatTextView>(R.id.result)

        backButton.setOnClickListener {
            findNavController().popBackStack()
        }

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

        result.setOnClickListener {
            requireActivity().shareText(result.text.toString())
        }
    }

    private fun barrelVolume(height: Int, topRadius: Int, midRadius: Int) =
        Math.PI * height * (2 * topRadius * topRadius + midRadius * midRadius) / 12000000
}
