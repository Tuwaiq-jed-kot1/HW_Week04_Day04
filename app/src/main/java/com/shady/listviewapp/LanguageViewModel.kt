package com.shady.listviewapp
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



    class LanguageViewModel(private val repository: LanguageRepository) : ViewModel() {


        fun insert(word:Language) = viewModelScope.launch {
            repository.insert(Language)
        }
    }

    class LanguageViewModelFactory(private val repository: LanguageRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LanguageViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return LanguageViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }








