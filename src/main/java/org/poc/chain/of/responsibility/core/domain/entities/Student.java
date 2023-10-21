package org.poc.chain.of.responsibility.core.domain.entities;

import lombok.Builder;
import lombok.Data;
import org.poc.chain.of.responsibility.core.domain.valueobjects.CPF;
import org.poc.chain.of.responsibility.core.domain.valueobjects.Email;

import java.util.Date;

@Data
@Builder
public class Student {
    private final CPF cpf;
    private final String fullName;
    private final Email email;
    private final Date birthDate;

    public Student(
            final CPF cpf,
            final String fullName,
            final Email email,
            final Date birthDate
    ) {
        this.cpf = cpf;
        this.fullName = fullName;
        this.email = email;
        this.birthDate = birthDate;
    }
}
