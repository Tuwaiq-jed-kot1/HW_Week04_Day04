package com.shady.listviewapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private lateinit var langList: List<String>

class AppRepo(context: Context) {
    private val appRepo = AppDataBase.getAppDatabase(context)!!

    suspend fun getAllLanguages1(): List<Language> = withContext(Dispatchers.IO) {
        appRepo.languageDao.getAllLanguages()
    }
    val context=context
    suspend fun fillDB()= withContext(Dispatchers.IO) {
        val dataDB = appRepo.languageDao.getAllLanguages()
        if (dataDB.isEmpty()) {
            langList = listOf("Android", "Java", "Php", "Hadoop")
            for (i in 1..3) {
                val technology = Language(
                    langName = langList[i],
                    id = i
                )
                appRepo.languageDao.insert(technology)
            }
        }}


}
