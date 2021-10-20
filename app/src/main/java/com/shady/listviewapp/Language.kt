package com.shady.listviewapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Language(
    @ColumnInfo(name="language")
    @PrimaryKey
    val lang: String
) {}
