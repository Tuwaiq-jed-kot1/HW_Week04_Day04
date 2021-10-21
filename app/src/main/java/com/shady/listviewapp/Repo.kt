package com.shady.listviewapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class Repo(context: Context) {
    private val appdatabase = AppDatabase.getAppdatabase(context)!!
    private lateinit var langList: List<String>
    suspend fun getAll():List<AndroidApps> = withContext(Dispatchers.IO ){
        appdatabase.userDao.getAll()
    }

    suspend fun fillDB() = withContext(Dispatchers.IO) {
        val data = appdatabase.userDao.getAll()
        if (data.isEmpty()) {
            langList = listOf("Android" ," java", "php", "Haoop")
            for (i in 1..5) {
                val tec = AndroidApps(
                    appName = langList[i],
                    appid = i,
                )
                appdatabase.userDao.insert(tec)

            }
        }
    }
}