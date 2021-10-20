package com.shady.listviewapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoTechLang {
    @Insert
    suspend fun insert(techLang: TechLang)

    @Query("SELECT * FROM table_tech_lang")
    suspend fun getAllTechLang(): List<TechLang>

    @Query("DELETE FROM table_tech_lang")
    suspend fun deleteAll()


}