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
            "https://www.surehire.com/wp-content/uploads/2021/10/5-key-Elements-of-a-Lone-Worker-policy.png.webp",
            "John",
            "Smith",
            "Ageing Workshops Manager",
            "731-985-6412"
        ),
        Contact(
            "https://img.freepik.com/free-photo/confident-young-male-engineer-wearing-safety-helmet-uniform-standing-profile-view-looking-side-while-keeping-arms-crossed-isolated-white-background-with-copy-space_141793-133104.jpg",
            "Liam",
            "Johnson",
            "Engineer-technologist",
            "202-555-0121"
        ),
        Contact(
            "https://scontent.fevn6-2.fna.fbcdn.net/v/t1.18169-9/12809646_116616615399488_8735848977373582110_n.jpg?_nc_cat=101&cb=c578a115-2e46c7d2&ccb=1-5&_nc_sid=174925&_nc_ohc=ODwJyBVAvWUAX-m5wMT&_nc_ht=scontent.fevn6-2.fna&oh=00_AT_2eC3iT_ubZAZt9t6yUPQUPTFLbpGsjmSy549JoMVhdA&oe=61E1E35A",
            "Noah",
            "Williams",
            "Barrel-maker",
            "786-986-1682"
        ),
        Contact(
            "https://media.istockphoto.com/id/163204230/photo/young-construction-worker-carrying-wood-boards.jpg?s=612x612&w=0&k=20&c=fImTSVkOFQqwiyc2keRYbQQCOFfwSMMkrCCKN7d6ujY=",
            "Oliver",
            "Brown",
            "Cognac Spirit Processing Worker",
            "254-378-8024"
        ),
        Contact(
            "",
            "Elijah",
            "Jones",
            "Cognac Spirit Processing Worker",
            "316-892-9719"
        ),
        Contact(
            "https://scontent.fevn6-1.fna.fbcdn.net/v/t1.18169-9/14963159_1099199023533765_5746824400089907211_n.jpg?_nc_cat=103&ccb=1-5&_nc_sid=174925&_nc_ohc=rpq7JAPthXYAX-s7zKu&tn=AEtzMbQ8ObOeNdiP&_nc_ht=scontent.fevn6-1.fna&oh=00_AT9vJ-67Zm6sC9gimn5oJsxPA8yJGHTOgzN2S9WB4oSLag&oe=61E13636",
            "Lucas",
            "Garcia",
            "Cognac Spirit Processing Worker",
            "954-277-1376"
        )
    )
}