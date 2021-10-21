package com.shady.listviewapp


import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var arrayAdapter: ListAdapter
    private lateinit var fillButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.lvListView)
        fillButton = findViewById(R.id.btnFill)


        val mvModel = ViewModelProvider(this).get(MVModel::class.java)
        mvModel.fillDataBase()

        fillButton.setOnClickListener(){
            mvModel.getAllTechnology().observe(this, Observer {
                arrayAdapter= ArrayAdapter<Technologies>(this, simple_list_item_1, android.R.id.text1,it )
                listView.adapter = arrayAdapter
            })
        }
    }
}