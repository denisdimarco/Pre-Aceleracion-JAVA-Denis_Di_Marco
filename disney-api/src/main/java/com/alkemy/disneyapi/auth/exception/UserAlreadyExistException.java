package com.alkemy.disneyapi.auth.exception;


public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String message) {
        super(message);
    }

}