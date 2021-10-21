package com.shady.listviewapp

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM(context: Application) : AndroidViewModel(context){
    private val repo = AppRepo(context)

    fun getAllUsers(): MutableLiveData<List<ArrayTechnologyDataClass>> {
        val users = MutableLiveData<List<ArrayTechnologyDataClass>>()
        //val localcontest = Context
        viewModelScope.launch {
            users.postValue(repo.getAllUsers())
        }
        return users
    }

    fun fillDB() = viewModelScope.launch {
        repo.fillDB()
    }
}