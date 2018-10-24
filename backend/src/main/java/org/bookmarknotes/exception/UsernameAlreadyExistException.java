package org.bookmarknotes.exception;

/**
 * Created by zealot on 10.08.18.
 */
public class UsernameAlreadyExistException extends RuntimeException {
    public UsernameAlreadyExistException(String message) {
        super(message);
    }
}
