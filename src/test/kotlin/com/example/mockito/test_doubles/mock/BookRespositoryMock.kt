package com.example.mockito.test_doubles.mock

import kotlin.test.assertEquals

class BookRepositoryMock: BookRepository{

    var saveCalled: Int = 0
    var lastAddedBook: Book? = null

    override fun save(book: Book) {
        saveCalled++
        lastAddedBook = book
    }

    fun verify(book: Book, times: Int){
        assertEquals(times, saveCalled)
        assertEquals(book, lastAddedBook)
    }

}