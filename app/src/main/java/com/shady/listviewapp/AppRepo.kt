package com.shady.listviewapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepo(context: Context) {
    private val appDB = AppDataBase.getAppDatabase(context)!!

    suspend fun getAllUsers(): List<ArrayTechnologyDao> = withContext(Dispatchers.IO) {
        appDB.userDao.getAllUsers()
    }

    suspend fun fillDB() = withContext(Dispatchers.IO){
        val dataDB = appDB.userDao.getAllUsers()

        if (dataDB.isEmpty()) {
            for (i in 1..4) {
                val user = ArrayTechnologyDataClass(
                    id = i,
                    languageName = "Language Name: $i"
                )
                appDB.userDao.insert(user)
            }
        }
    }
}