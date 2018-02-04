package com.wikrgroup.exercise.core.exceptions;

/**
 * Created by vlad on 14.11.16.
 */
public class NotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -9096770598926743934L;

    //Parameterless Constructor
    public NotImplementedException() {
    }

    //Constructor that accepts a message
    public NotImplementedException(String message) {
        super(message);
    }

}
