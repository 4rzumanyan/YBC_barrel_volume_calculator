package com.example.ybcaging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ContactsAdapter(val contacts: List<Contact>) :
    RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {


    //2 find views of the item
    class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contactImage = itemView.findViewById<AppCompatImageView>(R.id.worker_image)
        val contactFirstname = itemView.findViewById<AppCompatTextView>(R.id.firstname)
        val contactLastname = itemView.findViewById<AppCompatTextView>(R.id.lastname)
        val contactPosition = itemView.findViewById<AppCompatTextView>(R.id.position)
        val contactPhoneNumber = itemView.findViewById<AppCompatTextView>(R.id.phone_number)
    }

    //1 returns viewHolder with inflated view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactsViewHolder(itemView)
    }

    //3
    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(contacts[position].imageUrl).placeholder(
            R.drawable
                .worker
        ).centerCrop().into(holder.contactImage)
        holder.contactFirstname.text = contacts[position].firstname
        holder.contactLastname.text = contacts[position].lastname
        holder.contactPosition.text = contacts[position].position
        holder.contactPhoneNumber.text = contacts[position].phoneNumber

    }

    //4 set contacts list item count
    override fun getItemCount() = contacts.count()

}