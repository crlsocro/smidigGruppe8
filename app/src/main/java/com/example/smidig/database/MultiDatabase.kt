package com.example.smidig.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Quiz::class, Marker::class, Login::class], version = 6)
abstract class MultiDatabase: RoomDatabase() {
    abstract fun getQDao(): QuizDao
    abstract  fun getMDao(): MarkerDao
    abstract fun getLDao(): LoginDao

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
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance.also { INSTANCE = it }
            }
        }
    }
}