package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM(context: Application) : AndroidViewModel(context) {
    private val repo = AppRepo(context)

    fun getAllTech(): MutableLiveData<List<Language>>{
    val lang = MutableLiveData<List<Language>>()
    viewModelScope.launch {
        lang.postValue((repo.getAllTech()))
    }
        return lang

    }

    fun fillDB() = viewModelScope.launch {
        repo.fillDB()
    }
}