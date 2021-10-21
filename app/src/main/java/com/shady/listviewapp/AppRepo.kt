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
    val locContext =context
    suspend fun fillDB()= withContext(Dispatchers.IO) {
        val dataDB= appDB.LangDao.getAllLang()
        langList = locContext.resources.getStringArray(R.array.array_technology).toList()

        if (dataDB.isEmpty()) {
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