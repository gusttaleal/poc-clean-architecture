package org.poc.chain.of.responsibility.core.domain.valueobjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.poc.chain.of.responsibility.core.domain.exceptions.InvalidCPF;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CPFTest {

    @Test
    @DisplayName("Should successful create CPF")
    void shouldSuccessfulCreateCPF() {
        String expected = "000.000.000-00";
        CPF actual = CPF.builder().cpf(expected).build();

        assertEquals(expected, actual.getCpf());
    }

    @Test
    @DisplayName("Should throws CPFException when CPF is invalid")
    void shouldThrowsCPFExceptionWhenCPFIsInvalid() {
        assertThrows(InvalidCPF.class, () -> CPF.builder().cpf(null).build());
        assertThrows(InvalidCPF.class, () -> CPF.builder().cpf("").build());
    }
}
