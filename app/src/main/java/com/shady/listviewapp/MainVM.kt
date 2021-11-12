package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVm(context: Application) : AndroidViewModel(context) {
    private val repo = AppRepo(context)

    fun getAllLang(): MutableLiveData<List<LanguageTabel>> {
        val users = MutableLiveData<List<LanguageTabel>>()
        viewModelScope.launch {
            users.postValue(repo.getAllLang())
        }
        return users
    }
    fun fillDB() = viewModelScope.launch{
        repo.fillDB()
    }

}