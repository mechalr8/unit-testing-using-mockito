package com.exaple.mockito.annotations.support

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class AnnotationTest {

    @InjectMocks
    private lateinit var bookService: BookService

    @Mock
    private lateinit var bookRepository: BookRepository

    @Test
    fun demoCreateMocksUsingAnnotations(){

        val book1 = Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 = Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())

        val books = ArrayList<Book>()
        books.add(book1)
        books.add(book2)
        Mockito.`when`(bookRepository.findNewBooks(7)).thenReturn(books)

        val newListWithAppliedDiscount = bookService.getNewBookWithAppliedDiscount(10, 7)

        assertEquals(2, newListWithAppliedDiscount.size)
        assertEquals(477, newListWithAppliedDiscount[0].getPrice())
        assertEquals(432, newListWithAppliedDiscount[1].getPrice())
    }
}