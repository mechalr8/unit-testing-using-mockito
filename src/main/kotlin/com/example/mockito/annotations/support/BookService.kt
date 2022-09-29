package com.example.mockito.annotations.support

class   BookService(bookRepository: com.example.mockito.annotations.support.BookRepository) {
    private var bookRepository: com.example.mockito.annotations.support.BookRepository? = bookRepository

    fun getNewBookWithAppliedDiscount(discountRate: Int, days: Int): List<com.example.mockito.annotations.support.Book>{
        val newBooks = bookRepository?.findNewBooks(days)

        newBooks?.forEach {
            val price = it.getPrice()
            val newPrice = price - (discountRate * price / 100)
            it.setPrice(newPrice)
        }

        return newBooks!!
    }

}