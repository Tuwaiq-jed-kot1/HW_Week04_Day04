package com.shady.listviewapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepo (context: Context) {
    private val appDB= AppDataBase.getAppDataBase(context)!!
    private lateinit var langList: List<String>
    suspend fun getAllLang(): List<LanguageTabel> = withContext(Dispatchers.IO) {
        appDB.LangDao.getAllLang()
    }
    suspend fun fillDB()= withContext(Dispatchers.IO) {
        val dataDB= appDB.LangDao.getAllLang()
        if (dataDB.isEmpty()) {
            langList = listOf("Android", "Java", "Php", "Hadoop")
            for (i in 1..3) {
                val lang = LanguageTabel(
                    LanguageType=langList[i],

                    id = i + 1
                )
                appDB.LangDao.insert(lang)

            }
        }
    }
}