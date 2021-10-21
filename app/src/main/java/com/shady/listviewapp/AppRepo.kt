package com.shady.listviewapp

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class AppRepo(context: Context) {

    private val appDB: AppDatabase = AppDatabase.getAppDatabase(context)!!
    //private  var id = (0..500).random()

    suspend fun getAllUsers(): List<Book> =
        withContext(Dispatchers.IO) { appDB.bookDao.getAllBooks() }

    suspend fun fillDB() = withContext(Dispatchers.IO) {
        val dataDB = appDB.bookDao.getAllBooks()
        if (dataDB.isEmpty()) {
            for (i in 1..100) {
                val user = Book(
                    bookName = "bookName $i",
                    bookAuthor = "lName $i",
                    bookID =  i
                )
                appDB.bookDao.insert(user)
            }
        }
    }
}