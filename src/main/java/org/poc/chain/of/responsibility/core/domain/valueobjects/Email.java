package org.poc.chain.of.responsibility.core.domain.valueobjects;

import lombok.Builder;
import lombok.Data;
import org.poc.chain.of.responsibility.core.domain.exceptions.InvalidEmail;

import java.util.Objects;

@Data
@Builder
public class Email {
    private String email;

    public Email(final String email) {
        validate(email);
        this.email = email;
    }

    private void validate(final String email) {
        boolean isValid = !Objects.isNull(email) && email.matches(
                "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*"
                        + "@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        if (!isValid)
            throw new InvalidEmail("The e-mail address: [" + email + "] is not valid.");
    }
}
