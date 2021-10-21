package com.shady.listviewapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AppRepo(context: Context) {
    private val appDataBase = AppDataBase.getAppDataBase(context)!!

    suspend fun getAllTechnology():List<Technologies> = withContext(Dispatchers.IO){
        appDataBase.technoDao.getAllTechnology()
    }
    val locContext =context
    suspend fun fillDataBase()= withContext(Dispatchers.IO){
        val dataValues = appDataBase.technoDao.getAllTechnology()

        val langArray:List<String> = locContext.resources.getStringArray(R.array.array_technology).toList()
        if(dataValues.isEmpty()){
            for (i in 1..12){
                val technology = Technologies(
                    name= langArray[i],
                    id= i
                )
                appDataBase.technoDao.insert(technology)
            }
        }
    }
}