package com.shady.listviewapp

import androidx.room.*


    @Dao
    interface InterfaceDao {


        @Insert
        fun insert(lang:Table)

        @Query("select * from lang")
         fun getAllLang():List<Table>

        @Update
         fun update(lang:Table)

        @Delete
         fun delete(lang:Table)

        @Query("select * from lang where id == :uId ")
         fun selectUserById(uId:Int):Table
    }
