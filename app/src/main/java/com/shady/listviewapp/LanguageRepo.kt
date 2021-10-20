package com.shady.listviewapp

import android.content.Context
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update

class LanguageRepo(contex:Context) {
    private val langDB=LanguageDataBase.getAppDataBase(contex)!!


    suspend fun insert(language: Language) {
        langDB.dao.insert(language)
    }


    suspend fun getAllLanguage( ):List<Language>  {
        return langDB.dao.getAllLanguage()
    }


    suspend fun updateLanguage(language: Language){}



    suspend fun delete(language: Language){}


}