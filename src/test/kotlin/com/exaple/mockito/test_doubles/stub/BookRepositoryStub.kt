package com.exaple.mockito.test_doubles.stub

import java.time.LocalDate

class BookRepositoryStub : BookRepository {
    private val bookStore: MutableMap<String, Book> = mutableMapOf<String, Book>()

    override fun findNewBooks(days: Int): List<Book> {
        val newBooks = mutableListOf<Book>()
        val book1 = Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 = Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())
        newBooks.add(book1)
        newBooks.add(book2)
        return newBooks
    }
}
