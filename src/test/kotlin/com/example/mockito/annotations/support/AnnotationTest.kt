package com.example.mockito.annotations.support

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
    private lateinit var bookService: com.example.mockito.annotations.support.BookService

    @Mock
    private lateinit var bookRepository: com.example.mockito.annotations.support.BookRepository

    @Test
    fun demoCreateMocksUsingAnnotations(){

        val book1 =
            com.example.mockito.annotations.support.Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 =
            com.example.mockito.annotations.support.Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())

        val books = ArrayList<com.example.mockito.annotations.support.Book>()
        books.add(book1)
        books.add(book2)
        Mockito.`when`(bookRepository.findNewBooks(7)).thenReturn(books)

        val newListWithAppliedDiscount = bookService.getNewBookWithAppliedDiscount(10, 7)

        assertEquals(2, newListWithAppliedDiscount.size)
        assertEquals(477, newListWithAppliedDiscount[0].getPrice())
        assertEquals(432, newListWithAppliedDiscount[1].getPrice())
    }
}