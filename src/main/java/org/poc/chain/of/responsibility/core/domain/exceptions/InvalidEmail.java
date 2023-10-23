package org.poc.chain.of.responsibility.core.domain.exceptions;

public class InvalidEmail extends RuntimeException {
    public InvalidEmail(String message) {
        super(message);
    }
}
