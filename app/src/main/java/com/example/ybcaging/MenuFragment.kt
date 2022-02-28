package com.example.ybcaging

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MenuFragment : Fragment(R.layout.activity_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }

    private fun setupView(view: View) {
        val barrelVolumeButton = view.findViewById<AppCompatTextView>(R.id.barrel_volume_button)
        val tankVolumeButton = view.findViewById<AppCompatTextView>(R.id.tank_volume_button)
        val carboyVolumeButton = view.findViewById<AppCompatTextView>(R.id.carboy_volume_button)
        val contactsButton = view.findViewById<AppCompatTextView>(R.id.contacts_button)
        val aboutButton = view.findViewById<AppCompatTextView>(R.id.about_button)
        val backButton = view.findViewById<AppCompatImageView>(R.id.back_button)

        barrelVolumeButton.setOnClickListener {
            findNavController().navigate(R.id.calcFragment)
        }

        contactsButton.setOnClickListener {
            findNavController().navigate(R.id.contactsFragment)
        }

        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}