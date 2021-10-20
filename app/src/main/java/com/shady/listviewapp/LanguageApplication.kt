package com.shady.listviewapp

import android.app.Application

    import android.app.Application
    import kotlinx.coroutines.CoroutineScope
    import kotlinx.coroutines.SupervisorJob

    class LanguageApplication : Application() {

        val applicationScope = CoroutineScope(SupervisorJob())


        val database by lazy { languageRoomDatabase.getDatabase(this, applicationScope) }
        val repository by lazy { LanguageRepository(database.languageDao()) }
    }













}