package com.shady.listviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "array_technology_table")
data class ArrayTechnologyDataClass(
    @PrimaryKey
    val id: Int,
    val languageName: String
    )