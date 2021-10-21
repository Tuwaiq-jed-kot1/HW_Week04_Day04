package com.shady.listviewapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


    @Database(entities = [Table::class],version=1,exportSchema = false)
    abstract class LangDB : RoomDatabase() {
        abstract val IDoa: InterfaceDao


        companion object {
            private var INSTANCE: LangDB? = null

            fun getLangDB(context: Context): LangDB? {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, LangDB::class.java, "lang-database").build()
                }
                return INSTANCE
            }
        }
    }
