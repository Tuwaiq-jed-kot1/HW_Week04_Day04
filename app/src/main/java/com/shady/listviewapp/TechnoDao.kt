package com.shady.listviewapp

import androidx.room.*

@Dao
interface TechnoDao {
    @Insert
    suspend fun insert(technology: Technology)

    @Query("select * From technology_table")
    suspend fun getAllTechnology():List<Technology>

    @Update
    suspend fun update(technology: Technology)

    @Delete
    suspend fun delete(technology: Technology)

    @Query("select * From technology_table where id== :technoId")
    suspend fun selectUserById(technoId:Int):Technology
}