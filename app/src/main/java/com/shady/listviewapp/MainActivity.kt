package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlin.concurrent.thread
import android.view.Gravity
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var langList: List<String>
    private lateinit var arrayAdapter: ListAdapter
    private lateinit var btnLang:Button
    private lateinit var langs : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.lvListView)

        btnLang=findViewById(R.id.btn1)

        val vmLang = ViewModelProvider(this).get(MainViewModel::class.java)
        vmLang.fillDataBase()
        langs=ArrayList()
        btnLang.setOnClickListener {
            vmLang.getAllTechnology().observe(this, Observer {
                it.forEach { langs.add(it.name)  }
                arrayAdapter = ArrayAdapter<String>(this, simple_list_item_1, android.R.id.text1 ,langs)
                listView.adapter = arrayAdapter})

        }

        listView.setOnItemClickListener { _,_,i,_ ->
            Toast.makeText(this, langs[i], Toast.LENGTH_SHORT).let{
                it.setGravity(Gravity.TOP,0,0)
                it.show()
            }
        }
    }
}