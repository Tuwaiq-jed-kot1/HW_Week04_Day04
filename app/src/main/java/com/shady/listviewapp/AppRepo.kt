package com.shady.listviewapp

import android.content.Context

class AppRepo(context: Context) {
    private val appDatabase: AppDatabase = AppDatabase.getAppDatabase(context)

   suspend fun insert(techLang: TechLang) {
        appDatabase.daoTechLang.insert(techLang)
    }

    suspend fun getAllTechLang(): List<TechLang> {
        return appDatabase.daoTechLang.getAllTechLang()
    }

    suspend fun deleteAll() {
        appDatabase.daoTechLang.deleteAll()
    }

   suspend fun fillDB(context: Context) {
        if (appDatabase.daoTechLang.getAllTechLang().isEmpty()) {
            context.resources.getStringArray(R.array.array_technology).forEach {
                insert(TechLang(it))
            }
        }
    }

}