package com.mahila.listviewapp

import android.content.Context
import com.shady.listviewapp.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class AppRepo(context: Context) {
    private val appDB = AppDataBase.getAppDataBase(context)!!
    val context = context
    suspend fun getAllTech(): List<Technology> = withContext(Dispatchers.IO) {
        appDB.techDao.getAllTech()
    }

    suspend fun fillDB() = withContext(Dispatchers.IO) {

        val langList = context.resources.getStringArray(R.array.array_technology).toList()

        val dataDB = appDB.techDao.getAllTech()
        if (dataDB.isEmpty()) {
            var id = 100
            for (i in langList) {

                val tech = Technology(
                    idTech = id,
                    name = i
                )
                appDB.techDao.insert(tech)
                id++
            }
        }
    }
}