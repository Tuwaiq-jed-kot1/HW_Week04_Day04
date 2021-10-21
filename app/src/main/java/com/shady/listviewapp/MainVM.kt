package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainVM(context: Application): AndroidViewModel(context) {

    private val repo = Apprepo(context)


    fun getAllTech():MutableLiveData<List<Technology>>{
        val technologes = MutableLiveData<List<Technology>>()
        viewModelScope.launch {
            technologes.postValue(repo.getAllTech())
        }
        return technologes
    }

    fun fillDB()=viewModelScope.launch {
        repo.fillDB()
    }

}