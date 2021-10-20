package com.shady.listviewapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TechLang::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val daoTechLang: DaoTechLang

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "database_my_app")
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }
}