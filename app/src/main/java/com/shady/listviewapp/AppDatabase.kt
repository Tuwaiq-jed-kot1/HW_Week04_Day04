package com.shady.listviewapp

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Dao
@Database(entities = [TechTable::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract val techDao: TechDao

    companion object{
        private var INSTANCE: AppDatabase? = null
        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "app-database"
                ).build()
            }
            return INSTANCE
        }
    }
}