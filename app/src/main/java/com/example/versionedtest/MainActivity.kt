package com.example.versionedtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.versionedtest.entities.Director
import com.example.versionedtest.entities.School
import com.example.versionedtest.entities.Student
import com.example.versionedtest.entities.Subject
import com.example.versionedtest.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            Director("Mohamed Gamal", "El fostat school")
        )

        val schools = listOf(
            School("El fostat school")
        )

        val subjects = listOf(
            Subject("Programming")
        )

        val students = listOf(
            Student("Youssef hussein", 2, "El fostat school")
        )

        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Mohamed Gamal", "Programming")
        )

        lifecycleScope.launch {
            directors.forEach{dao.insertDirector(it)}
            schools.forEach{dao.insertSchool(it)}
            subjects.forEach{dao.insertSubject(it)}
            students.forEach{dao.insertStudent(it)}
            studentSubjectRelations.forEach{dao.insertStudentSubjectCrossRef(it)}
        }

    }
}