package com.exaple.mockito.test_doubles.dummy

class FakeBookRepository: BookRepository {

    private val bookStore: MutableMap<String, Book> = mutableMapOf<String, Book>()

    override fun save(book: Book) {
        bookStore[book.getBookId()] = book
    }

    override fun findAll(): Collection<Book> {
        return bookStore.values
    }
}