package com.shady.listviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "language_table")
data class Language(@PrimaryKey val id: Int, val langName: String)
