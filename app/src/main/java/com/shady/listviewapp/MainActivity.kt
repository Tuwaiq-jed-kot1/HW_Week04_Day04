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
    private lateinit var btnFill: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.lvListView)
        btnFill =findViewById(R.id.btnFill)

        val mainVM= ViewModelProvider(this).get(MainVM::class.java)
        MainVM.fillDataBase()

        brnFill.setOnClickListener(){
            MainVM.getAllLang().observe(this, Observer {
                arrayAdapter= ArrayAdapter<Table>(this, simple_list_item_1, android.R.id.text1,it )
                listView.adapter = arrayAdapter
    }
}
    }
