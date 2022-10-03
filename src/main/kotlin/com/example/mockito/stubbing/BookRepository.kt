package com.example.mockito.stubbing


interface BookRepository {
    fun findNewBooks(days: Int): List<Book>
    fun findBookByBookId(it: String): Book
}
