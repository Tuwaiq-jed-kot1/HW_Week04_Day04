package com.shady.listviewapp


    import androidx.room.*

    @Dao
    interface TechDao {
        @Insert
        suspend fun insert(technology: Technologies)

        @Query("select * From technology_table")
        suspend fun getAllTechnology():List<Technologies>

        @Update
        suspend fun update(technology: Technologies)

        @Delete
        suspend fun delete(technology: Technologies)

        @Query("select * From technology_table where id== :technoId")
        suspend fun selectUserById(technoId:Int):Technologies
    }
