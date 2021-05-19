package com.example.smidig.database

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(context: Context): ViewModel() {
    private var userDao: UserDao = UserDatabase.get(context).getUDao()

    fun addUser(testB: User){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                userDao.addUser(testB)
            }
        }
    }
}