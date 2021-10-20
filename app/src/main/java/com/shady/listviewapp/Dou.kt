package com.shady.listviewapp

import androidx.room.*

@Dao
interface Dou {
    @Insert
    suspend fun insert(language: Language)

    @Query("select*from language")
    suspend fun getAllLanguage():List<Language>

    @Update
    suspend fun updateLanguage(language: Language)

    @Delete
    suspend fun delete(language: Language)
}
