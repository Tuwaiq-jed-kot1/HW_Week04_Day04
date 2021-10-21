package com.shady.listviewapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lang")
data class Table (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String?)
