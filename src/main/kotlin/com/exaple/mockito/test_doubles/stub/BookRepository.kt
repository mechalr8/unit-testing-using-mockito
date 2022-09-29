package com.exaple.mockito.test_doubles.stub


interface BookRepository {
    fun findNewBooks(days: Int): List<Book>
}
