package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var arrayAdapter: ListAdapter
    private lateinit var  appButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainVM = ViewModelProvider(this).get(MainVM::class.java)
        mainVM.fillDB()


        listView = findViewById(R.id.lvListView)
        appButton = findViewById(R.id.button)

        appButton.setOnClickListener {
            mainVM.getAll().observe(this, Observer {
                arrayAdapter = ArrayAdapter<AndroidApps>(this, simple_list_item_1, android.R.id.text1,it)
                listView.adapter = arrayAdapter
            })
        }


    }



}