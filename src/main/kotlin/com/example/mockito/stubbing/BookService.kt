package com.example.mockito.stubbing

class   BookService(bookRepository: BookRepository) {
    private var bookRepository: BookRepository? = bookRepository

    fun getNewBookWithAppliedDiscount(discountRate: Int, days: Int): List<Book>{
        val newBooks = bookRepository?.findNewBooks(days)

        newBooks?.forEach {
            val price = it.getPrice()
            val newPrice = price - (discountRate * price / 100)
            it.setPrice(newPrice)
        }

        return newBooks!!
    }

    fun calculateTotalCost(bookIds: List<String>): Int{
        var total: Int = 0
        bookIds.forEach{
            val book: Book = bookRepository?.findBookByBookId(it)!!;
            total = total + book.getPrice()
        }
        return total
    }

    fun addBook(book: Book){
        bookRepository?.save(book)
    }
}