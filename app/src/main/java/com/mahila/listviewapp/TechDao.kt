package com.mahila.listviewapp

import androidx.room.*
@Dao
interface TechDao {
    @Insert
    suspend fun insert(tech: Technology)
    @Query("select * From technology_table ")
    suspend fun getAllTech() : List<Technology>

    @Update()
    suspend fun update(tech: Technology)

    @Delete
    suspend fun delete(tech: Technology)

    @Query("select * from technology_table where idTech== :tId")
    suspend fun selectTechById(tId: Int): Technology
}