package com.example.versionedtest

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.versionedtest.entities.Director

import com.example.versionedtest.entities.School
import com.example.versionedtest.entities.Student
import com.example.versionedtest.entities.Subject
import com.example.versionedtest.entities.relations.SchoolAndDirector
import com.example.versionedtest.entities.relations.SchoolWithStudents
import com.example.versionedtest.entities.relations.StudentSubjectCrossRef
import com.example.versionedtest.entities.relations.StudentsWithSubjects
import com.example.versionedtest.entities.relations.SubjectWithStudents

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Transaction // To avoid any multithreading issues and executes the below block as one transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>

    // ============================= one to many relationship queries

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction // To avoid any multithreading issues and executes the below block as one transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    // ============================= many to many relationship queries

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction // To avoid any multithreading issues and executes the below block as one transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>

    @Transaction // To avoid any multithreading issues and executes the below block as one transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectOfStudent(studentName: String): List<StudentsWithSubjects>


}
