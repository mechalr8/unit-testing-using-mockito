package com.exaple.mockito.test_doubles.dummy

class BookService(private var bookRepository: BookRepository?, private var emailService: EmailService?) {


    fun addBook(book: Book){
        bookRepository!!.save(book)
    }

    fun findNumberOfBooks(): Int{
        return bookRepository!!.findAll().size
    }

    //Other Methods
}