package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM (context: Application) : AndroidViewModel(context){
    private val repo = AppRepo(context)

    fun getAllList(): MutableLiveData<List<Languge>> {
        val languge = MutableLiveData<List<Languge>>()
        viewModelScope.launch {
            languge.postValue(repo.getAllList())
        }
        return languge
    }

    fun fillDB()  = viewModelScope.launch {
        repo.fillDB()
    }

}