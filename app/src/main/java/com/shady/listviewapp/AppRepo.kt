package com.shady.listviewapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import android.R
import android.widget.ArrayAdapter
import android.widget.ListView

private lateinit var langList: List<String>

class AppRepo (context: Context) {
    private val appRepo = AppDataBase.getAppDatabase(context)!!

    suspend fun getAllList(): List<Languge> = withContext(Dispatchers.IO) {
        appRepo.lanDao.getAllUsers()
    }
    val context=context
suspend fun fillDB()= withContext(Dispatchers.IO) {
    val dataDB = appRepo.lanDao.getAllUsers()
    if (dataDB.isEmpty()) {
        langList = listOf("Android", "Java", "Php", "Hadoop")
        for (i in 1..3) {
            val technology = Languge(
                type = langList[i],
                id = i
            )
            appRepo.lanDao.insert(technology)
        }
    }
}}