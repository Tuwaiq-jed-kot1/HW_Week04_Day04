package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var fillButton: Button
    private lateinit var arrayAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lvListView)
        fillButton = findViewById(R.id.btnFill)

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.fillDataBase()

        fillButton.setOnClickListener(){
            mainViewModel.getAllTechnology().observe(this, Observer {
                arrayAdapter= ArrayAdapter<Technology>(this, simple_list_item_1, android.R.id.text1,it )
                listView.adapter = arrayAdapter
            })
        }
    }
}