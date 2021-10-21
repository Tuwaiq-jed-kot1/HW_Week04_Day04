package com.shady.listviewapp

import androidx.room.*


@Dao
interface TechDao {
    @Insert
    suspend fun insert(table: TechTable)

    @Query("SELECT * From techTable ")
    suspend fun getAllTables() : List<TechTable>

    @Update
    suspend fun update(table: TechTable)

    @Delete
    suspend fun delete(table: TechTable)

    @Query("SELECT * From techTable Where id == :techId ")
    suspend fun selectTableById(techId: Int): TechTable
}