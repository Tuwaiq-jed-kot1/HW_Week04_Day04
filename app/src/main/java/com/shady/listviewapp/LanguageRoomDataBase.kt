package com.shady.listviewapp
package com.example.android.roomwordssample
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [language::class], version = 1)
abstract class WordRoomDatabase : Roomlanguage() {

    abstract fun languageDao(): languageDao

    companion object {
        @Volatile
        private var INSTANCE: languageRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): languageRoomDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "language_database"
                )

                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class languageDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.languageDao())
                    }
                }
            }
        }


        suspend fun populateDatabase(wordDao:LanguageDao) {

            languageDao.deleteAll()

            var language = Language("Kotlin")
            languageDao.insert(language)
            language = Language("Android!")
            languageDao.insert(language)
        }
    }
}
