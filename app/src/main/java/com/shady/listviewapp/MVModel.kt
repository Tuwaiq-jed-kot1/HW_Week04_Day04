package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MVModel(context: Application):AndroidViewModel(context) {
    private val repo =  AppRepo(context)

    fun getAllTechnology():MutableLiveData<List<Technologies>>{
        val technology = MutableLiveData<List<Technologies>>()
        viewModelScope.launch {
            technology.postValue(repo.getAllTechnology())
        }
        return technology
    }

    fun fillDataBase()=viewModelScope.launch {
        repo.fillDataBase()
    }
}