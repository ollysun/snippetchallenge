package com.webspoon.coding.challange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SnippetException extends RuntimeException {

    public SnippetException(String message) {
        super(message);
    }
}
