package com.shady.listviewapp

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [AndroidApps::class], version =1 , exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao : DaoT

    companion object{

        private var INSTANCE :AppDatabase?= null
        fun getAppdatabase(context: Context) :AppDatabase?{
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(

                    context.applicationContext,AppDatabase::class.java,"array_technology"
                ).build()
            }
            return INSTANCE
        }
    }

}
