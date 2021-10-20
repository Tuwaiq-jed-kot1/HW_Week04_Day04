package com.shady.listviewapp

import androidx.room.*


@Dao
interface LanguageDao {

    @Insert
    suspend fun insert(lang: Language)

    @Query("select * From Language ")
    suspend fun getAllLanguages() : List<Language>

    @Update()
    suspend fun update(lang: Language)

    @Delete
    suspend fun delete(lang: Language)



}