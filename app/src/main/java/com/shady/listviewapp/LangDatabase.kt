package com.shady.listviewapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Lang:: class] , version = 1 ,exportSchema = false)
abstract class LangDatabase: RoomDatabase() {
    abstract val LangDao: LangDao

    companion object{
        private var INSTANCE :LangDatabase?= null
        fun getAppDataBase(context: Context): LangDatabase? {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    LangDatabase::class.java,
                    "App-database"

                ).build()
            }
            return INSTANCE
        }
    }
}