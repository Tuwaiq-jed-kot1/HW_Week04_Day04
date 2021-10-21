package com.shady.listviewapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepo (context: Context) {
    private val appDB = AppDataBase.getAppDataBase(context)!!

    suspend fun getAllTech() :  List<Language> =
        withContext(Dispatchers.IO) {
        appDB.langDao.getAllTech()
    }
    val _context = context
    suspend fun fillDB() =  withContext(Dispatchers.IO) {
        val dataDB = appDB.langDao.getAllTech()
        val langList: List<String> = _context.resources
            .getStringArray(R.array.array_technology).toList()
        if (dataDB.isEmpty()) {
            for(i in 1..5){
                val lang= Language(langList[i])
                appDB.langDao.insert(lang)
            }


            }
        }
    }
