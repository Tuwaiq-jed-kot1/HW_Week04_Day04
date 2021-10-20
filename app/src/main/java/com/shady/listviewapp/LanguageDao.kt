package com.shady.listviewapp

import androidx.room.*

@Dao
interface LanguageDao {
    @Insert
    suspend fun insert(lang: Language)
    @Query("SELECT * From language_table")
    fun getAllLanguages(): List<Language>
    @Update
    suspend fun update(lang: Language)
    @Delete
    suspend fun delete(lang: Language)

    @Query("select * from language_table where id == :uId ")
    suspend fun selectUserById(uId: Int):Language
}