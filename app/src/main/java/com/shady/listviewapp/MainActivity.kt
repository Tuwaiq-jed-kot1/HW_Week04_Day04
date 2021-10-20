package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var langList: List<String>
    private lateinit var arrayAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.lvListView)
        val mainViewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.fillDB()
//        mainViewModel.deleteAll()

        mainViewModel.getAllTechLang().observe(this, Observer {
            val list = mutableListOf<String>()
            it.forEach { list += it.lang }
            arrayAdapter = ArrayAdapter<String>(this, simple_list_item_1, android.R.id.text1, list)
            listView.adapter = arrayAdapter
        })
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${position} ", Toast.LENGTH_SHORT)
                .let {
                    it.setGravity(Gravity.TOP, 10, 10)
                    it.show()
                }
        }
    }
}