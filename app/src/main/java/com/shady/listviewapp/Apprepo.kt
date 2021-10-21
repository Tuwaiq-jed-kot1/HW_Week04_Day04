package com.shady.listviewapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.content.res.Resources.getSystem
import androidx.core.content.res.TypedArrayUtils.getString
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class Apprepo(context: Context) {

    private val appDB = AppDB.getAppDB(context)!!

    suspend fun getAllTech(): List<Technology> = withContext(Dispatchers.IO){
        appDB.tech.getAllTechnology()
    }


    var lContext = context
    suspend fun fillDB() = withContext(Dispatchers.IO){
        val dataDB = appDB.tech.getAllTechnology()
       val langArray: List<String> = lContext.resources.getStringArray(R.array.array_technology).toList()
         // val array: Array<String> = Resources.getSystem().getStringArray(R.array.array_technology)

        if (dataDB.isEmpty())
            for (i in 1..12) {
                val technology = Technology(
                    id = i,
                    techName = langArray[i]        //langArray.toString()
                )
                appDB.tech.insert(technology)
            }
        }
    }
