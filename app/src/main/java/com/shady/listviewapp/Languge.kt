package com.shady.listviewapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName= "list_table")
data class Languge (
    @PrimaryKey
    val type :String,
    val id: Int,


)