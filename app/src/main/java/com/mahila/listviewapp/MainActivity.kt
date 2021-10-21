package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mahila.listviewapp.MainActVM
import com.mahila.listviewapp.Technology

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var langList: List<String>
    private lateinit var arrayAdapter: ListAdapter
    private lateinit var fillButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.lvListView)
        langList = resources.getStringArray(R.array.array_technology).toList()
        fillButton = findViewById(R.id.btnFill)
        val mainVM = ViewModelProvider(this).get(MainActVM::class.java)
        mainVM.fillDB()
        fillButton.setOnClickListener {
            mainVM.getAllTech().observe(this, {
                arrayAdapter =
                    ArrayAdapter<Technology>(this, simple_list_item_1, android.R.id.text1)
                listView.adapter = arrayAdapter
            })
        }


        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${langList[position]} ,  $parent  $view $id", Toast.LENGTH_LONG)
                .let {
                    it.setGravity(Gravity.TOP, 10, 10)
                    it.show()
                }
            Log.e("Print List", "${langList[position]} ,  $parent  $view $id")
        }
    }
}