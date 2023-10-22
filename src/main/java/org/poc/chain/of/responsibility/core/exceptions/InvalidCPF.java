package org.poc.chain.of.responsibility.core.exceptions;

public class InvalidCPF extends RuntimeException {
    public InvalidCPF(final String message) {
        super(message);
    }
}
