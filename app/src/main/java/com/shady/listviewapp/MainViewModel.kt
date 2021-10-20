package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel(context: Application) : AndroidViewModel(context) {
    private val repo = LanguageRepo(context)
    fun getAllLanguage(): MutableLiveData<List<Language>> {
        val languages = MutableLiveData<List<Language>>()
        viewModelScope.launch {
            languages.postValue(repo.getAllLanguage())
        }
        return languages

    }

    fun fillDB() = viewModelScope.launch {
        if (repo.getAllLanguage().isEmpty()) {
            repo.insert(Language("kotlin"))
            repo.insert(Language("java"))
            repo.insert(Language("php"))
            repo.insert(Language("css"))
        }
    }

}
