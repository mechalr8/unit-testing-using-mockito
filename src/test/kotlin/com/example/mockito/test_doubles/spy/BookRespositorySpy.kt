package com.example.mockito.test_doubles.spy

class BookRepositorySpy: BookRepository{

    var saveCalled: Int = 0
    var lastAddedBook: Book? = null

    override fun save(book: Book) {
        saveCalled++
        lastAddedBook = book
    }

    fun timesCalled(): Int{
        return saveCalled
    }

    fun calledWith(book: Book): Boolean{
        return lastAddedBook!! == book
    }

}