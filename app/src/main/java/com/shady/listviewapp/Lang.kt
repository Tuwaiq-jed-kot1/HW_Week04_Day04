package com.shady.listviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "array_technology")
data class Lang (@PrimaryKey val langId:Int, val PlangName:String) {
}