package com.example.mockito.stubbing


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class BookServiceTest {

    @InjectMocks
    private lateinit var bookService: BookService

    @Mock
    lateinit var bookRepository: BookRepository

    @Test
    fun textCalculateTotalCostOfBooks(){
        val bookIds = mutableListOf<String>()
        bookIds.add("1234")
        bookIds.add("1235")

        val book1 = Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 = Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())

//        `when`(bookRepository.findBookByBookId("1234")).thenReturn(book1)
//        `when`(bookRepository.findBookByBookId("1235")).thenReturn(book2)

        doReturn(book1).`when`(bookRepository).findBookByBookId("1234")
        doReturn(book2).`when`(bookRepository).findBookByBookId("1235")
        val actualCost = bookService.calculateTotalCost(bookIds)
        assertEquals(1010, actualCost)
    }
}