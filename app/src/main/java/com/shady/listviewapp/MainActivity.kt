package com.shady.listviewapp

import android.R.layout.simple_list_item_1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.*
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var arrayAdapter: ListAdapter
    private lateinit var fillButton: Button
    private lateinit var appDB: AppDataBase
    private lateinit var langs: ArrayList<String>
    private lateinit var langList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.lvListView)
        fillButton = findViewById(R.id.btnFill)
        arrayAdapter = ArrayAdapter<String>(this, simple_list_item_1, android.R.id.text1, langs)
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${listView[position]} ,  $parent  $view $id", Toast.LENGTH_LONG)
                .let {
                    it.setGravity(Gravity.TOP, 10, 10)
                    fillButton = findViewById(R.id.btnFill)

                    val vmLang = ViewModelProvider(this).get(MainVM::class.java)
                    vmLang.fillDB()
                    langs = ArrayList()
                    fillButton.setOnClickListener {
                        vmLang.getAllList().observe(this, Observer {
                            it.forEach { langs.add(it.type) }
                            arrayAdapter = ArrayAdapter<String>(
                                this,
                                simple_list_item_1,
                                android.R.id.text1,
                                langs
                            )
                            listView.adapter = arrayAdapter
                        })

                    }

                    listView.setOnItemClickListener { _, _, i, _ ->
                        Toast.makeText(this, langs[i], Toast.LENGTH_SHORT).let {
                            it.setGravity(Gravity.TOP, 0, 0)
                            it.show()
                        }
                        Log.e("Print List", "${langList[position]} ,  $parent  $view $id")

                    }
                }
        }
    }
}