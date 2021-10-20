package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var arrayAdapter: ListAdapter
    private lateinit var btnLang:Button
    private lateinit var langs : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.lvListView)
        btnLang=findViewById(R.id.btnLang)

        val vmLang = ViewModelProvider(this).get(LangVM::class.java)
        vmLang.fillDB()
        langs=ArrayList()
            btnLang.setOnClickListener {
                vmLang.getAllLags().observe(this, Observer {
                    it.forEach { langs.add(it.PlangName)  }
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