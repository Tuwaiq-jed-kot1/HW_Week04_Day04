package com.shady.listviewapp


import androidx.room.*
import androidx.room.Dao


@Dao

interface Lang_Dar {

    @Insert
    suspend fun insert(lang: DB)

    @Query("select * From Programming_Language_table ")
    suspend fun getAllLangs(): List<DB>

    @Update()
    suspend fun update(lang: DB)

    @Delete
    suspend fun delete(lang: DB)
}



