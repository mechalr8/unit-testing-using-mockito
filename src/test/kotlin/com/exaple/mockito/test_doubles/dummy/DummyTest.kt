package com.exaple.mockito.test_doubles.dummy

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.time.LocalDate
import kotlin.test.assertEquals

class DummyTest {

    @Test
    fun demoDummy(){
        val bookRepository = FakeBookRepository()
        val emailService: EmailService = DummyEmailService()
        val bookService = BookService(bookRepository, emailService)
        bookService.addBook(Book("1234", "Mockito in Action", 530, LocalDate.now().toString()))
        bookService.addBook(Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString()))
        assertEquals(2, bookService.findNumberOfBooks())
    }

    @Test
    fun demoDummyWithMockito(){
        val bookRepository = mock(BookRepository::class.java)
        val emailService: EmailService = mock(EmailService::class.java)
        val bookService = BookService(bookRepository, emailService)

        val book1 = Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 = Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())

        val books = ArrayList<Book>()
        books.add(book1)
        books.add(book2)

        `when`(bookRepository.findAll()).thenReturn(books)
        assertEquals(2, bookService.findNumberOfBooks())
    }
}