package com.example.versionedtest.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "School")
@Entity
data class School(
    @PrimaryKey(autoGenerate = false)
    val schoolName: String
)
