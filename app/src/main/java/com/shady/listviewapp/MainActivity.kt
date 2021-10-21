package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var arrayAdapter: ListAdapter
    private lateinit var fillButton: Button
    private lateinit var appDB: AppDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fillButton = findViewById(R.id.btnFill)
        listView = findViewById(R.id.lvListView)

        val mainVM = ViewModelProvider(this).get(MainVm::class.java)
        mainVM.fillDB()

        fillButton.setOnClickListener {
            mainVM.getAllLang().observe(this, Observer {
                arrayAdapter = ArrayAdapter<LanguageTabel>(this, simple_list_item_1, android.R.id.text1, it)

                listView.adapter = arrayAdapter})
        }
    }
}