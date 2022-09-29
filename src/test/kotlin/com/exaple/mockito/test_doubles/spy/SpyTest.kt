package com.exaple.mockito.test_doubles.spy

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SpyTest {

    @Test
    fun demoSpy(){
        val bookRepositorySpy = BookRepositorySpy()
        val bookService = BookService(bookRepositorySpy)

        val book1 = Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 = Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())

        bookService.addBook(book1)
        assertEquals(0, bookRepositorySpy.timesCalled())

        bookService.addBook(book2)
        assertEquals(1, bookRepositorySpy.timesCalled())


        assertTrue(bookRepositorySpy.calledWith(book2))
    }

    @Test
    fun spyMockWithMockito(){
        val bookRepository: BookRepository = spy(BookRepository::class.java)
        val bookService = BookService(bookRepository)

        val book1 = Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 = Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())

        bookService.addBook(book1)
        bookService.addBook(book2)

        verify(bookRepository, times(1)).save(book2)
        verify(bookRepository, times(0)).save(book1)
    }
}