package com.example.mockito.test_doubles.fake

class FakeBookRepository: BookRepository {

    private val bookStore: MutableMap<String, Book> = mutableMapOf<String, Book>()

    override fun save(book: Book) {
        bookStore[book.getBookId()] = book
    }

    override fun findAll(): Collection<Book> {
        return bookStore.values
    }
}