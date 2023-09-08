package com.example.versionedtest.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "Director") // Entity represents a table in the database
@Entity
data class Director(
        @PrimaryKey(autoGenerate = false) // We set it to false as we are making a string a primary key and we need to keep them as it is
        val directorName: String,
        val schoolName: String
)