package com.shady.listviewapp

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Dao
@Database(entities = [Technologies::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract val technoDao:TechDao

    companion object{
        private var INSTANCE:AppDataBase? = null
        fun getAppDataBase(context: Context):AppDataBase? {
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                ).build()
            }
            return INSTANCE
        }
    }
}