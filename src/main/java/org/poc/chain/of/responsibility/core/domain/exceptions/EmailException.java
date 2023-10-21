package org.poc.chain.of.responsibility.core.domain.exceptions;

public class EmailException extends RuntimeException {
    public EmailException(String message) {
        super(message);
    }
}
