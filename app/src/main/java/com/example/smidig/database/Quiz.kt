package com.example.smidig.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Creates a table for the quiz
//Currently not used
@Entity(tableName = "quiz_table")
data class Quiz(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "quizID")
    val quizID: Int,
    @ColumnInfo(name = "Username")
    val name: String?,
    @ColumnInfo(name = "email")
    val email: String?,
    @ColumnInfo(name = "password")
    val password: String?,
)