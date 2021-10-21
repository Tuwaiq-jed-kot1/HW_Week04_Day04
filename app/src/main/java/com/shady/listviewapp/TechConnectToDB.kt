package com.shady.listviewapp

import androidx.room.*


@Dao
interface TechConnectToDB{

    @Insert
    suspend fun insert(technology: Technology)

    @Query("select * from technology_table")
    suspend fun getAllTechnology(): List<Technology>

    @Update
    suspend fun update(technology: Technology)

    @Delete
    suspend fun delete(technology: Technology)
}