package org.poc.chain.of.responsibility.infra.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.poc.chain.of.responsibility.core.exceptions.ErrorWhenCipherPassword;
import org.poc.chain.of.responsibility.core.domain.valueobjects.Password;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JavaxCryptoCipherTest {
    private JavaxCryptoCipher javaxCryptoCipher;

    @BeforeEach
    void setup() {
        javaxCryptoCipher = new JavaxCryptoCipher();
    }

    @Test
    @DisplayName("Should validate decrypt method")
    void shouldValidateDecrypt() throws ErrorWhenCipherPassword {
        String expected = "123asd";
        Password password = javaxCryptoCipher.encrypt(expected);

        String actual = javaxCryptoCipher.decrypt(password);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should throw an exception when encrypt method was called")
    void shouldThrowExceptionEncrypt() {
        assertThrows(ErrorWhenCipherPassword.class, () -> javaxCryptoCipher.encrypt(null));
    }

    @Test
    @DisplayName("Should throw an exception when decrypt method was called")
    void shouldThrowExceptionDecrypt() {
        assertThrows(ErrorWhenCipherPassword.class, () -> javaxCryptoCipher.decrypt(null));
    }


}
