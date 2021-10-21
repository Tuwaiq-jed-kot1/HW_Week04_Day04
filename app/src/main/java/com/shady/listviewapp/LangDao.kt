package com.shady.listviewapp

import androidx.room.*

@Dao
interface LangDao {
    @Insert
    fun insert(lang:LanguageTabel )

    @Query("select * From Language_Tabel")
    fun getAllLang() : List<LanguageTabel>

    @Update()
    fun update(user: LanguageTabel)

    @Delete
    fun delete(user: LanguageTabel)

    @Query("select * from Language_Tabel where id== :LId")
    fun selectLangById(LId: Int): LanguageTabel
}