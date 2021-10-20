package com.shady.listviewapp
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = " language_table")
 data class Language (val language :String)
}