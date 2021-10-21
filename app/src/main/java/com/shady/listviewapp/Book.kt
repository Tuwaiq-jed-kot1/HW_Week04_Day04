package com.shady.listviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "bookTable")
data class Book(
    @PrimaryKey
    val bookName: String,
    val bookAuthor: String,
    val bookID: Int,
)