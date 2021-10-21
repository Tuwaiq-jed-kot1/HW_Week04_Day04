package com.shady.listviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tech_Table")
data class Language (
    @PrimaryKey
    val langName: String
        )
