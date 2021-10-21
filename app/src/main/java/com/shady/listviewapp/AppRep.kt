package com.shady.recycleviewapp

import android.content.Context
import com.shady.listviewapp.LangDB
import com.shady.listviewapp.Table

class AppRep(context: Context) {
    private val langDB= LangDB.getLangDB(context)!!

    suspend fun getAllUsers(): List<Table> = langDB.InterfaceDao.getAllLang()

    suspend fun fillDB(){
        val dataDB= langDB.InterfaceDao.getAllLang()
        if (dataDB.isEmpty()) {
            for (i in 1..100) {
                val lang = Table(
                    id = "id $i",
                    name = "name $i",
                    id = i,
                )
                langDB.InterfaceDao.insert(lang)

            }
        }
    }
}

