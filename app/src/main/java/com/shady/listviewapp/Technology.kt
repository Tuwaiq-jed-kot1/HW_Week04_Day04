package com.shady.listviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "technology_table")
data class Technology (
    @PrimaryKey
    val id: Int,
    val name: String
)