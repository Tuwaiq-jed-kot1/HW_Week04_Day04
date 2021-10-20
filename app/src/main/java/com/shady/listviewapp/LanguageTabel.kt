package com.shady.listviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Language_Tabel")
data class LanguageTabel (
        @PrimaryKey
        val id:Int,
        val LanguageType: String

        )
