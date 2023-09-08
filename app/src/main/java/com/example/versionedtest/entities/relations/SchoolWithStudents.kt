package com.example.versionedtest.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.versionedtest.entities.School
import com.example.versionedtest.entities.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)