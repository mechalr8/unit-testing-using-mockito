package com.example.mockito.test_doubles.mock

class BookService(private var bookRepository: BookRepository?) {


    fun addBook(book: Book){
        if(book.getPrice() > 480)
            return
        bookRepository!!.save(book)
    }

//    fun findNumberOfBooks(): Int{
//        return bookRepository!!.findAll().size
//    }

    //Other Methods
}