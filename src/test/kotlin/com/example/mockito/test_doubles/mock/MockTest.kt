package com.example.mockito.test_doubles.mock

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MockTest {

    @Test
    fun demoMock(){
        val bookRepositoryMock = BookRepositoryMock()
        val bookService = BookService(bookRepositoryMock)

        val book1 = Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 = Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())

        bookService.addBook(book1)
        bookService.addBook(book2)

        bookRepositoryMock.verify(book2, 1)
    }

    @Test
    fun demoMockWithMockito(){
        val bookRepository: BookRepository = mock(BookRepository::class.java)
        val bookService = BookService(bookRepository)

        val book1 = Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 = Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())

        bookService.addBook(book1)
        bookService.addBook(book2)

        verify(bookRepository, times(1)).save(book2)
        verify(bookRepository, times(0)).save(book1)
    }
}