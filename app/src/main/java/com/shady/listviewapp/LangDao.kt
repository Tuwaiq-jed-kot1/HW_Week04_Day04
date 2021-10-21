package com.shady.listviewapp

import androidx.room.*

@Dao
interface LangDao {
    @Insert
    suspend fun insert(language: Language)

    @Query("select * From tech_table")
    suspend fun getAllTech(): List<Language>

    @Update
    suspend fun update(language: Language)

    @Delete
    suspend fun delete(language: Language)

}