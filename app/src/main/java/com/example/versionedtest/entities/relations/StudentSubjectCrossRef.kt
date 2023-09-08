package com.example.versionedtest.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["studentName", "subjectName"]) // Here we annotated it with entity as this will be a reference to a many to many relationship which should be presented in a separate table and this is how we reference the primary keys from the other tables to be a foreign keys in this relation / table here
data class StudentSubjectCrossRef(
    val studentName: String,
    val subjectName: String
)