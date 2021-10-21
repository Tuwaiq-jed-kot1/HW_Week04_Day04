package com.shady.listviewapp


import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class Repo(context: Context) {

    val cntx=context
    private val appDB =AppDataBase.getAppDataBase(context)!!



    suspend fun getAllLangs():List<DB> = withContext(Dispatchers.IO) {
            appDB.languageDao.getAllLangs()
        }


    suspend fun fillDB()= withContext(Dispatchers.IO){

            val dataDB = appDB.languageDao.getAllLangs()
        val langList:List<String> = cntx.resources.getStringArray(R.array.array_technology).toList()

        if (dataDB.isEmpty()) {
            for(i in 1..langList.size-1){

               // val lang =l(i, langList[i])
                val lang =DB( langList[i])

              //  context.resources.getStringArray(R.array.array_technology).forEach {
                   appDB.languageDao.insert(lang)
                }

            }}

}