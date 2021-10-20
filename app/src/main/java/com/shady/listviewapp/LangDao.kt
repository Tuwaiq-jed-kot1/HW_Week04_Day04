package com.shady.listviewapp

import androidx.room.*


@Dao
interface LangDao {
    @Insert
    suspend fun insert(lang:Lang) // suspend: means put it on different thread

    @Query("select * from array_technology")
    suspend  fun getAllLangs():List<Lang>

    @Update()
    suspend fun update(lang:Lang)

    @Delete
    suspend fun delete(lang:Lang)

    @Query("select * from array_technology where langId == :langId")
    suspend fun selectUserById(langId :Int):Lang
}