package com.shady.listviewapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Language::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract val langDao: LangDao

    companion object{
        private var INSTANCE: AppDataBase? = null
        fun getAppDataBase(context: Context): AppDataBase? {
            if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "app-database").build()
            }
         return INSTANCE
        }
    }
}