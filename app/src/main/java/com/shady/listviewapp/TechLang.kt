package com.shady.listviewapp


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_tech_lang")
data class TechLang(
    @PrimaryKey @ColumnInfo(name = "Programing Language") val lang: String
)