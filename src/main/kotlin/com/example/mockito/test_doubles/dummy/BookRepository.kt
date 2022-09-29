package com.example.mockito.test_doubles.dummy


interface BookRepository {
    fun save(book: Book)
    fun findAll(): Collection<Book>
}
