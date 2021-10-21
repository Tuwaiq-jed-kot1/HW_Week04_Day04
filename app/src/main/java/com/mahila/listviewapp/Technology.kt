package com.mahila.listviewapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "technology_table")
data class Technology(
    @PrimaryKey
    val idTech: Int, val name: String
) {


}
