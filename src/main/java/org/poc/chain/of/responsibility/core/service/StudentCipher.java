package org.poc.chain.of.responsibility.core.service;

import org.poc.chain.of.responsibility.core.exceptions.ErrorWhenCipherPassword;
import org.poc.chain.of.responsibility.core.domain.valueobjects.Password;

public interface StudentCipher {
    Password encrypt(String key) throws ErrorWhenCipherPassword;

    String decrypt(Password password) throws ErrorWhenCipherPassword;
}
