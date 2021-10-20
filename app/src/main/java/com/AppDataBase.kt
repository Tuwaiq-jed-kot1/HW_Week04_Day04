package com

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Language::class],version=1,exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract val languageDao: LanguageDao


    companion object {
        private var INSTANCE: AppDataBase? = null

        fun getAppDataBase(context: Context): AppDataBase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDataBase::class.java, "lang-database").build()
            }
            return INSTANCE
        }
    }
}