package com.shady.listviewapp
package com.example.android.roomwordssample

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class LanguageRepository(private val languageDao:  LanguageDao) {


    val all languages: Flow<List< Language>> = LanguageDao.getAlphabetizedLanguages()


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert( languages:languages) {
        languagesDao.insert(languages)
    }
}
