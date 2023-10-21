package org.poc.chain.of.responsibility.core.domain.valueobjects;

import org.poc.chain.of.responsibility.core.domain.exceptions.EmailException;

public class Email {
    private final String email;

    public Email(final String email) throws EmailException {
        if (validate(email)) {
            this.email = email;
        } else {
            throw new EmailException("The e-mail address is not valid.");
        }
    }

    public String getEmail() {
        return email;
    }

    private boolean validate(final String email) {
        return email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }

    @Override
    public String toString() {
        return "Email[" +
                "email='" + email + '\'' +
                ']';
    }
}
