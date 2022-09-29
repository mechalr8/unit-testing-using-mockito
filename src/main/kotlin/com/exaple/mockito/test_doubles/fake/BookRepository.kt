package com.exaple.mockito.test_doubles.fake


interface BookRepository {
    fun save(book: Book)
    fun findAll(): Collection<Book>

}
