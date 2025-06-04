package com.mobile.bce

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.mobile.bce.database.MyDatabaseHelper

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reasult)

        val dbHelper = MyDatabaseHelper(this)
        val cursor = dbHelper.getAllUsers()
        val userList = mutableListOf<String>()

        if(cursor.moveToFirst())
        {
            do{
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val address = cursor.getString(cursor.getColumnIndexOrThrow("address"))
                val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
                val gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"))
                val country = cursor.getString(cursor.getColumnIndexOrThrow("country"))
                val terms = cursor.getString(cursor.getColumnIndexOrThrow("terms"))

                userList.add("Name:$name , Address: $address , Email : $email , Gender:$gender, Country:$country , Terms:$terms ")
            }while (cursor.moveToNext())
        }

    cursor.close()

        val listView = findViewById<ListView>(R.id.txtResult)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,userList)
        listView.adapter =adapter
    }
}