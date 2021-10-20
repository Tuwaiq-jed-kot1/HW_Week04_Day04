package com.shady.listviewapp

import android.app.Application
import android.content.Context
import android.content.ContextParams
import androidx.core.content.ContextCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LangRepo(context: Context) {
    val cntx=context
    private val langDB = LangDatabase.getAppDataBase(context )!!

    suspend fun getAllLangs():List<Lang> = withContext(Dispatchers.IO)
    {langDB.LangDao.getAllLangs()}

    suspend fun fillDB() = withContext(Dispatchers.IO){
        val langs = langDB.LangDao.getAllLangs()
        val langList:List<String> = cntx.resources.getStringArray(R.array.array_technology).toList()
        if (langs.isEmpty()) {
            for(i in 1..langList.size-1){
                val lang =Lang(i, langList[i])
                langDB.LangDao.insert(lang)
            }

        }}



}