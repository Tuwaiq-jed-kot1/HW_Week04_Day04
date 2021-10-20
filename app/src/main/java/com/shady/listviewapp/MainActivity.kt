package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.MainViewModel
import com.example.listviewapp.R

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lvListView)

        val mainVM = ViewModelProvider(this).get(MainViewModel::class.java)
        mainVM.fillDB()

        listView.adapter =
            ArrayAdapter(this, simple_list_item_1, android.R.id.text1, listOf<String>())

        mainVM.getAllLanguages().observe(this, Observer {
            var langList: MutableList<String> = mutableListOf()
            it.forEach { langList.add("${it.lang} Language") }
            listView.adapter = ArrayAdapter(this, simple_list_item_1, android.R.id.text1, langList)
        })


        listView.setOnItemClickListener { _, _, _, _ ->
            Toast.makeText(this, "Did you just click something?..", Toast.LENGTH_LONG).let {
                it.setGravity(Gravity.TOP, 10, 10)
                it.show()
            }

        }
    }
}
