package com.exaple.mockito.test_doubles.fake

class BookService(private var bookRepository: BookRepository?) {


    fun addBook(book: Book){
        bookRepository!!.save(book)
    }

    fun findNumberOfBooks(): Int{
        return bookRepository!!.findAll().size
    }

    //Other Methods
}