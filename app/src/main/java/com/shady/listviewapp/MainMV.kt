package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shady.recycleviewapp.AppRep
import kotlinx.coroutines.launch

class MainVM(context: Application) : AndroidViewModel(context) {
    private val repo = AppRep(context)

    fun getAllLang(): MutableLiveData<List<Table>> {
        val lang = MutableLiveData<List<Table>>()
        fun getAllLang() = viewModelScope.launch {
            Table.postValue(repo.getAllLang())
        }
        return lang
    }

fun fillDataBase()= viewModelScope.launch {
    repo.fillDB()
}