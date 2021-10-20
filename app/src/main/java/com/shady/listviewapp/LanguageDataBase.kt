package com.shady.listviewapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf (Language::class),version = 1,exportSchema = false)
abstract class LanguageDataBase: RoomDatabase() {
    abstract  val dao:Dou
    companion object{
        private var INSTANCE:LanguageDataBase?=null
        fun getAppDataBase(Context: Context):LanguageDataBase?{
            if(INSTANCE==null){
                INSTANCE= Room.databaseBuilder(
                    Context.applicationContext,
                    LanguageDataBase::class.java,
                    "app-databass"
                ).build()

            }
            return INSTANCE
        }
    }
}
