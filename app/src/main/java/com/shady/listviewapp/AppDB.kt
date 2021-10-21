package com.shady.listviewapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Technology::class],version = 2, exportSchema = false)

abstract class AppDB : RoomDatabase() {

    abstract val tech : TechConnectToDB

    companion object{
        private var INSTANCE: AppDB? = null

        fun getAppDB(context: Context):AppDB?{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "App_Data_Base"
                ).build()
            }
            return INSTANCE
        }
    }
}