package com.shady.listviewapp


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "techTable")
data class TechTable(
    @PrimaryKey
    val id : Int,
    val name : String,
)