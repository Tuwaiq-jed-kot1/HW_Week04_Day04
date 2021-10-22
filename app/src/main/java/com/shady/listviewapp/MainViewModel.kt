package com.shady.listviewapp

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(context: Application) : AndroidViewModel(context) {
    private val context by lazy { context }
    private val repo: AppRepo = AppRepo(context)
    fun insert(techLang: TechLang) {
        viewModelScope.launch {
            repo.insert(techLang)
        }
    }

    fun getAllTechLang(): MutableLiveData<List<TechLang>> {
        val techLangs = MutableLiveData<List<TechLang>>()
        viewModelScope.launch {
            delay(1000)
            techLangs.postValue(repo.getAllTechLang())
        }
        return techLangs
    }

    fun fillDB() {
        viewModelScope.launch {
            repo.fillDB(context)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repo.deleteAll()
        }
    }

    fun getStringAllTechLang(lifecycleOwner: LifecycleOwner): MutableLiveData<List<String>> {
        val stringList = mutableListOf<String>()
        val stringLiveList = MutableLiveData<List<String>>()
        viewModelScope.launch {
            getAllTechLang().observe(lifecycleOwner, Observer { list ->
                list.forEach {
                    stringList += it.lang
                }
            })
            stringLiveList.postValue(stringList)
        }
        return stringLiveList
    }

}