package com.exaple.mockito.test_doubles.fake

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.time.LocalDate
import kotlin.test.assertEquals

class FakeTest {

    @Test
    fun testFake(){
        val bookRepository: BookRepository = FakeBookRepository()
        val bookService = BookService(bookRepository)
        bookService.addBook(Book("1234", "Mockito in Action", 530, LocalDate.now().toString()))
        bookService.addBook(Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString()))
        assertEquals(2, bookService.findNumberOfBooks())
    }

    @Test
    fun testFakeWithMockito(){
        val bookRepository: BookRepository = mock(BookRepository::class.java)
        val bookService = BookService(bookRepository)

        val book1 = Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 = Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())

        val books = ArrayList<Book>()
        books.add(book1)
        books.add(book2)

        `when` (bookRepository.findAll()).thenReturn(books)
        assertEquals(2, bookService.findNumberOfBooks())
    }
}