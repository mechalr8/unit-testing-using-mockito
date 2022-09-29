package com.exaple.mockito.test_doubles.dummy


interface BookRepository {
    fun save(book: Book)
    fun findAll(): Collection<Book>
}
