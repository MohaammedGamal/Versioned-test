package com.example.versionedtest.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.versionedtest.entities.Director
import com.example.versionedtest.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName", // Refers to the school entity
        entityColumn = "schoolName" // Refers to the directory entity - using the mutual field between the two tables
    )
    val director: Director
)