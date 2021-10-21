package com.shady.listviewapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepo(context: Context) {

    private val appDB = AppDatabase.getAppDataBase(context)!!

    suspend fun getAllTables(): List<TechTable> = withContext(Dispatchers.IO){
        appDB.techDao.getAllTables()
    }
    val content = context
    suspend fun fillDB() = withContext(Dispatchers.IO) {
        val dataDB = appDB.techDao.getAllTables()
        val langList: List<String> = content.resources.getStringArray(R.array.array_technology).toList()
        if(dataDB.isEmpty()) {
            for (i in 1..12) {
                val table = TechTable(
                    id = i,
                    name = langList[i],
                )
                appDB.techDao.insert(table)
            }
        }
    }
}