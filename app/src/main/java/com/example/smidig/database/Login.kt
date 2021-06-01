package com.example.smidig.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//This code creates a Room entity(/table) for the database
//This entity contains the information for the login system
//Since this is a prototype/demo of our projects, security is not a priority
@Entity(tableName = "login_table")
data class Login(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userID")
    val userID: Int,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "password")
    val password: String,
)