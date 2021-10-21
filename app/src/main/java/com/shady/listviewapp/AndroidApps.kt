package com.shady.listviewapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "technology :" )
data class AndroidApps(

    @PrimaryKey
    val appid: Int,
    @ColumnInfo
    val appName: String,

    )
