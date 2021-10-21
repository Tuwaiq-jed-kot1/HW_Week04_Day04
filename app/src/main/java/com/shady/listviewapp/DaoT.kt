package com.shady.listviewapp

import androidx.room.*

@Dao
interface DaoT {
    @Query
        ("SELECT * FROM `technology :`")
   suspend fun getAll(): List<AndroidApps>

    @Query
        ("SELECT * FROM `technology :` WHERE appid IN (:appid)")
  suspend  fun loadAllByIds(appid: IntArray): List<AndroidApps>

    @Insert
  suspend  fun insert(vararg tec: AndroidApps)

    @Delete
   suspend fun delete(tec: AndroidApps)
}