package com.exaple.mockito.test_doubles.dummy

class DummyEmailService: EmailService {
    override fun sendEmail(message: String) {
        throw AssertionError("Method Not Implemented!!!")
    }
}