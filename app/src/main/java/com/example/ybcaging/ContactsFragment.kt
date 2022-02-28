package com.example.ybcaging

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactsFragment : Fragment(R.layout.activity_contacts) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }

    private fun setupView(view: View) {
        val adapter = ContactsAdapter(createContacts())
        val contactsRv = view.findViewById<RecyclerView>(R.id.contacts_rv)
        contactsRv.layoutManager = LinearLayoutManager(requireContext())
        contactsRv.adapter = adapter
        val backButton = view.findViewById<AppCompatImageView>(R.id.back_button)
        backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }


    private fun createContacts(): List<Contact> = listOf(
        Contact(
            "https://scontent.fevn6-3.fna.fbcdn.net/v/t31.18172-8/25300022_1233962553401189_1656134277769489915_o.jpg?_nc_cat=106&cb=c578a115-2e46c7d2&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=R1CPGhGn7OcAX9AEUDf&_nc_ht=scontent.fevn6-3.fna&oh=00_AT820UmNeaS93YpFKmZrYOvn0DfqWCBGLhza8mIL8vIung&oe=61E18EEA",
            "Artem",
            "Jraghatspanyan",
            "Ageing Workshops Manager",
            "095954438"
        ),
        Contact(
            "",
            "Vahe",
            "Ghazaryan",
            "Engineer-technologist",
            "055696869"
        ),
        Contact(
            "https://scontent.fevn6-2.fna.fbcdn.net/v/t1.18169-9/12809646_116616615399488_8735848977373582110_n.jpg?_nc_cat=101&cb=c578a115-2e46c7d2&ccb=1-5&_nc_sid=174925&_nc_ohc=ODwJyBVAvWUAX-m5wMT&_nc_ht=scontent.fevn6-2.fna&oh=00_AT_2eC3iT_ubZAZt9t6yUPQUPTFLbpGsjmSy549JoMVhdA&oe=61E1E35A",
            "Hayk",
            "Mirzoyan",
            "Barrel-maker",
            "041994050"
        ),
        Contact(
            "",
            "Tigran",
            "Sahakyan",
            "Cognac Spirit Processing Worker",
            "094209012"
        ),
        Contact(
            "",
            "Artur",
            "Fandunts",
            "Cognac Spirit Processing Worker",
            "077076177"
        ),
        Contact(
            "https://scontent.fevn6-1.fna.fbcdn.net/v/t1.18169-9/14963159_1099199023533765_5746824400089907211_n.jpg?_nc_cat=103&ccb=1-5&_nc_sid=174925&_nc_ohc=rpq7JAPthXYAX-s7zKu&tn=AEtzMbQ8ObOeNdiP&_nc_ht=scontent.fevn6-1.fna&oh=00_AT9vJ-67Zm6sC9gimn5oJsxPA8yJGHTOgzN2S9WB4oSLag&oe=61E13636",
            "Nikolay",
            "Sarafyan",
            "Cognac Spirit Processing Worker",
            "098154656"
        ),
        Contact(
            "",
            "Hrant",
            "Arzumanyan",
            "Cognac Spirit Processing Worker",
            "094908590"
        )
    )
}