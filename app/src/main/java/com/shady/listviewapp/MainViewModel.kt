package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(context: Application) : AndroidViewModel(context) {
    private val repo = Repo(context)

    fun getAllLanguages(): MutableLiveData<List<Language>> {
        val langLiveData = MutableLiveData<List<Language>>()
        viewModelScope.launch {
            langLiveData.postValue(repo.getAllLanguages())
        }
        return langLiveData
    }

    fun fillDB() = viewModelScope.launch { repo.fillDB() }


}