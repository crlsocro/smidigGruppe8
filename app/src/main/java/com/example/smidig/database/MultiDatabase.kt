package com.example.smidig.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//This code creates and sets up the main part of the database
@Database(entities = [Quiz::class, Marker::class, Login::class], version = 10)
abstract class MultiDatabase: RoomDatabase() {

    abstract fun getQDao(): QuizDao
    abstract  fun getMDao(): MarkerDao
    abstract fun getLDao(): LoginDao

    //this code is copied from our android development exam project finished earlier this semester

    companion object{
        var DB_FILENAME = "DB"

        @Volatile
        private var INSTANCE: com.example.smidig.database.MultiDatabase? = null

        fun get(context: Context): com.example.smidig.database.MultiDatabase {
            val tmp = INSTANCE
            if (tmp != null) {
                return tmp
            }
            synchronized(this){
                val instance =
                    Room.databaseBuilder(context.applicationContext, MultiDatabase::class.java, DB_FILENAME)
                    //We run this on the main thread due to async being unnecessary for this project  and too time consuming
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance.also { INSTANCE = it }
            }
        }
    }
}