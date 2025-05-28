package com.mobile.bce

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.bce.adapter.PersonAdapter
import com.mobile.bce.model.Person

class Person : AppCompatActivity() {

    private lateinit var recyclerView :RecyclerView
    private lateinit var personAdapter: PersonAdapter

    private  val personList = listOf(
        Person("Sandesh Prasai", "9807928148", "https://www.example.com"),
        Person("Sandesh Prasai", "9807928148", "https://www.example.com"),

        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_person)
        val toolbar :androidx.appcompat.widget.Toolbar = findViewById(R.id.acttoolbar)
        supportActionBar?.apply {
            title= "Person List"
            setDisplayHomeAsUpEnabled(true)
        }

        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        personAdapter = PersonAdapter(this , personList)
        recyclerView.adapter = personAdapter

    }
}