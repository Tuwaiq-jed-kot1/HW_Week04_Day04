package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM(context: Application) : AndroidViewModel(context) {
    private val repo = AppRepo(context)

    fun getAllBooks(): MutableLiveData<List<Book>> {
        val books = MutableLiveData<List<Book>>()
        viewModelScope.launch {
            books.postValue(repo.getAllUsers())
        }
        return books
    }


    fun fillDB() =
        viewModelScope.launch {
            repo.fillDB()
        }
}