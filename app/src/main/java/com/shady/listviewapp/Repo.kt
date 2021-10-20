package com.shady.listviewapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class Repo(context: Context) {
    private val appDB =AppDataBase.getAppDataBase(context)!!
    val contextGET=context
    suspend fun getAllLanguages():List<Language> =
        withContext(Dispatchers.IO) {
            appDB.languageDao.getAllLanguages()
        }


    suspend fun fillDB(){
        withContext(Dispatchers.IO) {
        val dataDB = appDB.languageDao.getAllLanguages()
        if (dataDB.isEmpty()){
            contextGET.resources.getStringArray(R.array.array_technology).forEach {
                appDB.languageDao.insert(Language(it))
            }

        }}
    }
}