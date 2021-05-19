package com.example.smidig.database

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun addUser(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): List<User>

    @Query("SELECT * FROM user_table WHERE userID = :userID ")
    fun getUserwithUserId(userID: Int): User
}