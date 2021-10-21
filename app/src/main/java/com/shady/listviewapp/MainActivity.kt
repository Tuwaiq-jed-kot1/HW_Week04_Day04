package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {


    private lateinit var fillButton: Button

    private lateinit var listView: ListView
    private lateinit var arrayAdapter: ListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.bookViewList)
        fillButton = findViewById(R.id.fillButton)

        val mainVM = ViewModelProvider(this).get(MainVM::class.java)
        mainVM.fillDB()

        listView.adapter =
            ArrayAdapter(this, simple_list_item_1, android.R.id.text1, listOf<String>())

        fillButton.setOnClickListener {
            mainVM.getAllBooks().observe(this, Observer {
                var bookList: MutableList<String> = mutableListOf()
                it.forEach { bookList.add("${it.bookName} ") }
                listView.adapter =
                    ArrayAdapter(this, simple_list_item_1, android.R.id.text1, bookList)
            })
        }


        listView.setOnItemClickListener { _, _, _, _ ->
            Toast.makeText(this, "You Want this Book ?", Toast.LENGTH_LONG).let {
                it.setGravity(Gravity.TOP, 10, 10)


            }
        }
    }
}
