package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*
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
        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.fillDB()

        mainViewModel.getAllLanguage().observe(this, Observer {
            val list = mutableListOf<String>()
            it.forEach { list += it.language }
            arrayAdapter = ArrayAdapter<String>(this, simple_list_item_1, android.R.id.text1,list)
            listView.adapter = arrayAdapter
        })


        // langList = listOf("Android", "Java", "Php", "Hadoop")

        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${langList[position]} ,  $parent  $view $id", Toast.LENGTH_LONG).let{
                it.setGravity(Gravity.TOP,10,10)
                it.show()
            }
            Log.e("Print List", "${langList[position]} ,  $parent  $view $id")
        }
    }
}