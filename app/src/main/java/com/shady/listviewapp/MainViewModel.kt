package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(context: Application):AndroidViewModel(context) {
    private val repo =  Repo(context)

    fun getAllTechnology():MutableLiveData<List<DB>>{
        val technology = MutableLiveData<List<DB>>()
        viewModelScope.launch {
            technology.postValue(repo.getAllLangs())
        }
        return technology
    }

    fun fillDataBase()=viewModelScope.launch {
        repo.fillDB()
    }
}