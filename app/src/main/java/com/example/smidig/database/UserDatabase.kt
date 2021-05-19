package com.example.smidig.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun getUDao(): UserDao

    companion object{
        var DB_FILENAME = "userDB"

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun get(context: Context): UserDatabase{
            val tmp = INSTANCE
            if (tmp != null) {
                return tmp
            }
            synchronized(this){
                val instance =
                    Room.databaseBuilder(context.applicationContext, UserDatabase::class.java, DB_FILENAME)
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance.also { INSTANCE = it }
            }
        }
    }
}