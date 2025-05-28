package com.mobile.bce.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.bce.R
import com.mobile.bce.model.Person

class PersonAdapter (

    private  val context: Context,
    private val personList: List<Person>

): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>(){
    inner class PersonViewHolder(view: View) :RecyclerView.ViewHolder(view) {

        val nameTextView : TextView = view.findViewById(R.id.nameTextView)
        val phoneTexView : TextView = view.findViewById(R.id.phoneText)
        val callButton: Button = view.findViewById(R.id.callBtn)
        val smsButton: Button = view.findViewById(R.id.smsBTn)
        val siteButton: Button = view.findViewById(R.id.siteBtn)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
//        TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(view)
    }


    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
//        TODO("Not yet implemented")
        val person = personList[position]
        holder.nameTextView.text= person.name
        holder.phoneTexView.text= person.phone


        holder.callButton.setOnClickListener{

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${person.phone}")
            context.startActivity(intent)
        }
        holder.smsButton.setOnClickListener{
            val intentSMS = Intent(Intent.ACTION_VIEW)
            intentSMS.data = Uri.parse("sms:${person.phone}")
            context.startActivity(intentSMS)
        }

        holder.siteButton.setOnClickListener{
            val intentSite = Intent(Intent.ACTION_VIEW)
            intentSite.data = Uri.parse(person.Website)
            context.startActivity(intentSite)
        }
        holder.itemView.setOnClickListener{
            val intentShare = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Name ${person.name} Phone ${person.phone}")
            }
            context.startActivity(Intent.createChooser(intentShare, "Share in"))
        }
    }

    override  fun getItemCount():Int =personList.size

}