package com.shady.listviewapp

import androidx.room.*

@Dao
interface TechnoDao {
    @Insert
    suspend fun insert(technology: Technology)

    @Query("select * From technology_table")
    suspend fun getAllTechnology():List<Technology>

    @Query("select * From technology_table where id== :technoId")
    suspend fun selectUserById(technoId:Int):Technology
}