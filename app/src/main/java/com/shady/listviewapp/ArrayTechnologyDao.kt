package com.shady.listviewapp

import androidx.room.*

@Dao
interface ArrayTechnologyDao {
    //CRUD, Create R
    @Insert
    suspend fun insert(user: ArrayTechnologyDataClass)

    @Query("Select * From array_technology_table")
    suspend fun getAllUsers() : List<ArrayTechnologyDao>

    @Update
    //fun updateUserName(id: Int, name: String)
    suspend fun update(user: ArrayTechnologyDao)

    @Delete
    suspend fun delete(user:ArrayTechnologyDao)

    @Query("Select * from array_technology_table where id== :uId")
    suspend fun selectUserById(uId: Int): ArrayTechnologyDao
}