package com.shady.listviewapp

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Dao
@Database(entities = [LanguageTabel::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract val LangDao: LangDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        fun getAppDataBase(context: Context): AppDataBase? {
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app-database"
                ).build()
            }
            return INSTANCE
        }
    }
}