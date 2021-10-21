package com.shady.listviewapp;

import android.content.Context;

import java.util.List;

import kotlinx.coroutines.Dispatchers;

class LangRepo(context: Context) {
    private val langDB = AppDatabase.getAppDataBase(context)!!

    suspend fun getAllLangs():List<Lang> = withContext(Dispatchers.IO)
    {langDB.LangDao.getAllLangs()}

    suspend fun fillDB() = withContext(Dispatchers.IO){
        val langs = langDB.LangDao.getAllLangs()
        val langList:List<String> = c.resources.getStringArray(R.array.array_technology).toList()
        if (langs.isEmpty()) {
            for(i in 1..langList.size-1){
                val lang =Lang(i, langList[i])
                langDB.LangDao.insert(lang)
            }

        }}
}
