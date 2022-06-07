package com.mysliukserhii.mynewcoursework.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mysliukserhii.mynewcoursework.room.AppDatabase
import com.mysliukserhii.mynewcoursework.user.User
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val usersDataBase = AppDatabase.getInstance(application).UserDao()

    fun insertUser(user: User) {
        viewModelScope.launch {
            usersDataBase.insert(user)
        }
    }
}
//class RegisterViewModel (application: Application) : AndroidViewModel(application) {
//    private val usersDataBase = AppStoreDataBase.getInstance(application).userDao()
//
//}