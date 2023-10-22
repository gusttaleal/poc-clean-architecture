package org.poc.chain.of.responsibility.core.domain.entities;

import lombok.Builder;
import lombok.Data;
import org.poc.chain.of.responsibility.core.domain.valueobjects.CPF;
import org.poc.chain.of.responsibility.core.domain.valueobjects.Email;
import org.poc.chain.of.responsibility.core.domain.valueobjects.Password;

import java.time.LocalDate;

@Data
@Builder
public class Student {
    private final CPF cpf;
    private final String fullName;
    private final Email email;
    private final LocalDate birthDate;
    private String enrollment;
    private Password password;
}
