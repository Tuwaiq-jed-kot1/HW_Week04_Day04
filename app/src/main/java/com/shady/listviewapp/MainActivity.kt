package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var arrayAdapter: ListAdapter
    private lateinit var fillButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.lvListView)
        fillButton = findViewById(R.id.btnFill)

        val mainVM = ViewModelProvider(this).get(MainVM::class.java)

        mainVM.fillDB()

        fillButton.setOnClickListener(){
            mainVM.getAllTables().observe(this, Observer {
                arrayAdapter = ArrayAdapter<TechTable>(this, simple_list_item_1, android.R.id.text1)
                listView.adapter = arrayAdapter
            })
        }
    }
        // langList = listOf("Android", "Java", "Php", "Hadoop")
        //arrayAdapter = ArrayAdapter<String>(this, simple_list_item_1, android.R.id.text1 ,langList)
       // listView.adapter = arrayAdapter
//        listView.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(this, "${langList[position]} ,  $parent  $view $id", Toast.LENGTH_LONG).let{
//                it.setGravity(Gravity.TOP,10,10)
//                it.show()
//            }
//            Log.e("Print List", "${langList[position]} ,  $parent  $view $id")
//        }

}