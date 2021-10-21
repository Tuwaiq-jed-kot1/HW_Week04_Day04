package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM(context: Application): AndroidViewModel(context) {

    private val repo = AppRepo(context)

    fun getAllTables(): MutableLiveData<List<TechTable>> {
        val tables = MutableLiveData<List<TechTable>>()
        viewModelScope.launch{
            tables.postValue(repo.getAllTables())
        }
        return tables
    }

    fun fillDB() = viewModelScope.launch {
            repo.fillDB()
        }

}