package com.shady.listviewapp


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Programming_Language_table")
data class DB(
    @PrimaryKey
    val name: String
) {}