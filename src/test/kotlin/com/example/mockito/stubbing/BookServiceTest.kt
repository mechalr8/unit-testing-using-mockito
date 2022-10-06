package com.example.mockito.stubbing


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
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
        bookIds.add("1234")

        val book1 = Book("1234", "Mockito in Action", 530, LocalDate.now().toString())
        val book2 = Book("1235", "JUnit 5 in Action", 480, LocalDate.now().toString())

        `when`(bookRepository.findBookByBookId("1234"))
            .thenReturn(book1)
            .thenReturn(book1)
//        `when`(bookRepository.findBookByBookId("1235")).thenReturn(book2)

//        doReturn(book1).`when`(bookRepository).findBookByBookId("1234")
//        doReturn(book2).`when`(bookRepository).findBookByBookId("1235")

        val actualCost = bookService.calculateTotalCost(bookIds)
        assertEquals(1060, actualCost)
    }


//    Stubbing void methods using Mockito. addBook calls the save method from the BookRepository and return type of \
//    save is void
    @Test
    fun testSaveBook(){
        val book1 = Book(null, "Mockito in Action", 530, LocalDate.now().toString())
        doNothing().`when`(bookRepository).save(book1)
        bookService.addBook(book1)
    }
}