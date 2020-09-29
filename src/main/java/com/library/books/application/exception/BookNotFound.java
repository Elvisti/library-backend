package com.library.books.application.exception;

public class BookNotFound {
    private String message;

    public BookNotFound( String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
