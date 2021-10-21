package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var langList: List<String>
    private lateinit var arrayAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.lvListView)
        langList = resources.getStringArray(R.array.array_technology).toList()
        // langList = listOf("Android", "Java", "Php", "Hadoop")
        arrayAdapter = ArrayAdapter<String>(this, simple_list_item_1, android.R.id.text1 ,langList)
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${langList[position]}", Toast.LENGTH_SHORT).let{
                it.setGravity(Gravity.TOP,10,10)
                it.show()
            }
            Log.e("Print List", "${langList[position]} ,  $parent  $view $id")
        }
    }
}