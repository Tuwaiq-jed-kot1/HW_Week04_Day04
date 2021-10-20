package com.shady.listviewapp

import androidx.room.*

@Dao
interface  LanDao {
    @Insert
    suspend fun insert(user: Languge)

    @Query("select * From list_table ")
    suspend fun getAllUsers() : List<Languge>

    @Update()
    suspend fun update(user: Languge)

    @Delete
    suspend fun delete(user: Languge)

    @Query("select * from LIST_TABLE where id== :uId")
    suspend fun selectUserById(uId: Int): Languge
}