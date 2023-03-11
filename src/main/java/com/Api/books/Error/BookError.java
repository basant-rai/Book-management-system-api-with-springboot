package com.Api.books.Error;


public class BookError extends Exception{
    public BookError() {
        super();
    }

    public BookError(String message) {
        super(message);
    }

    public BookError(String message, Throwable cause) {
        super(message, cause);
    }

    public BookError(Throwable cause) {
        super(cause);
    }

    protected BookError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
