package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM(context: Application): AndroidViewModel(context) {
    private val repo = AppRepo(context)

    fun getAllLanguages(): MutableLiveData<List<Language>> {
        val languages = MutableLiveData<List<Language>>()
        viewModelScope.launch {
            languages.postValue(repo.getAllLanguages1())
        }
        return  languages
    }

    fun fillDB() = viewModelScope.launch{ repo.fillDB() }
}