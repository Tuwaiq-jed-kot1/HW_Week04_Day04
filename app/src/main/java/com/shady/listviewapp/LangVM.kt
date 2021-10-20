package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LangVM(context: Application) : AndroidViewModel(context){
    private val langRepo =LangRepo(context)

    fun getAllLags(): MutableLiveData<List<Lang>> {
        val lang = MutableLiveData<List<Lang>>() //
         viewModelScope.launch { lang.postValue(langRepo.getAllLangs())}
        // postValue() is for update the value in the main data
        return lang
    }

    fun fillDB()= viewModelScope.launch { langRepo.fillDB() }
}