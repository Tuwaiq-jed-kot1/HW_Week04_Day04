package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var langList: List<String>
    private lateinit var arrayAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lvListView)

        val mainVM = ViewModelProvider(this).get(MainVM::class.java)
        mainVM.fillDB()

        langList = resources.getStringArray(R.array.array_technology).toList()
        arrayAdapter = ArrayAdapter<String>(this, simple_list_item_1, android.R.id.text1 ,langList)
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "${langList[position]}", Toast.LENGTH_LONG).let{
                it.setGravity(Gravity.TOP,10,10)
                it.show()
            }
        }
    }
}