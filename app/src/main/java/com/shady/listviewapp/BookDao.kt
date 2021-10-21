package com.shady.listviewapp
import androidx.room.*

@Dao
interface BookDao {
    @Insert
    suspend fun insert(user: Book)

    @Query("SELECT * FROM bookTable")
    suspend fun getAllBooks(): List<Book>

    @Update
    suspend fun update(user: Book)

    @Delete
    suspend fun delete(user: Book)

    @Query("SELECT * FROM bookTable WHERE bookID == :UID ")
     fun selectUserById(UID: Int): Book
}