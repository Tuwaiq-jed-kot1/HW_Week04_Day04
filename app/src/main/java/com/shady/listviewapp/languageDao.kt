package com.shady.listviewapp

import androidx.room.Dao
import androidx.room.vo.Dao

@Dao
interface LanguageDao {

        @Query("SELECT * FROM language_table ORDER BY word ASC")
        fun getAlphabetizedWords(): Flow<List<Word>>

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insert(language: language)

        @Query("DELETE FROM language_table")
        suspend fun deleteAll()
    }


}