package com.mahila.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainActVM (context: Application) : AndroidViewModel(context){
    private val repo = AppRepo(context)

    fun getAllTech(): MutableLiveData<List<Technology>> {
        val tech = MutableLiveData<List<Technology>>()
        viewModelScope.launch {
            tech.postValue(repo.getAllTech())
        }
        return tech
    }

    fun fillDB()  = viewModelScope.launch {
        repo.fillDB()
    }

}