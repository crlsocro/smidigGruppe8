package com.example.smidig.database

import androidx.room.*

@Dao
interface QuizDao {
    @Insert
    fun addUser(quiz: Quiz)

    @Update
    fun update(quiz: Quiz)

    @Delete
    fun delete(quiz: Quiz)

    @Query("SELECT * FROM quiz_table")
    fun getAllQuiz(): List<Quiz>

    @Query("SELECT * FROM quiz_table WHERE quizID = :quizID ")
    fun getQuizWithQuizId(QuizID: Int): Quiz
}