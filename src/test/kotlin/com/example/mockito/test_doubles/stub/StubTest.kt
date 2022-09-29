package com.example.mockito.test_doubles.stub

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.time.LocalDate
import kotlin.test.assertEquals

class StubTest {

    @Test
    fun demoStub(){
        val bookRepository: BookRepository = BookRepositoryStub()
        val bookService = BookService(bookRepository)
        val newListWithAppliedDiscount = bookService.getNewBookWithAppliedDiscount(10, 7)
        assertEquals(2, newListWithAppliedDiscount.size)
        assertEquals(477, newListWithAppliedDiscount[0].getPrice())
        assertEquals(432, newListWithAppliedDiscount[1].getPrice())
    }

    @Test
    fun demoStubWithMockito(){
        val bookRepository: BookRepository = mock(BookRepository::class.java)
        val bookService = BookService(bookRepository)

        val book1 = Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 = Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())

        val books = ArrayList<Book>()
        books.add(book1)
        books.add(book2)
        `when`(bookRepository.findNewBooks(7)).thenReturn(books)

        val newListWithAppliedDiscount = bookService.getNewBookWithAppliedDiscount(10, 7)

        assertEquals(2, newListWithAppliedDiscount.size)
        assertEquals(477, newListWithAppliedDiscount[0].getPrice())
        assertEquals(432, newListWithAppliedDiscount[1].getPrice())
    }
}