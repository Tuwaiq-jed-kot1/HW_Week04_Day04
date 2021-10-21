package com.shady.listviewapp


import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM (context: Application): AndroidViewModel(context){
    private val repo = Repo(context)

    fun getAll() :MutableLiveData<List<AndroidApps>>{
        val users = MutableLiveData<List<AndroidApps>>()
        viewModelScope.launch{
            users.postValue( repo.getAll())

        }
        return users
    }

    fun fillDB() =
        viewModelScope .launch {  repo.fillDB() }

}